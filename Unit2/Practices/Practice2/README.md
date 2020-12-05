# Practice #2
### LOGISTIC REGRESSION EXERCISE

1. Take the data
   
    Import a SparkSession with the Logistic Regression library
Optional: Use the Error reporting code
Create a Spark session
Use Spark to read the csv file Advertising.
Print the Schema of the DataFrame 

    ``` scala 
    import org.apache.spark.ml.classification.LogisticRegression
    import org.apache.spark.sql.SparkSession

    import org.apache.log4j._
    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession.builder().getOrCreate()

    val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")

    data.printSchema()
    ```

2. Deploy the data

    Print an example line
    ```scala 
    data.head(1)

    val colnames = data.columns
    val firstrow = data.head(1)(0)
    println("\n")
    println("Example data row")
    for(ind <- Range(1, colnames.length)){
        println(colnames(ind))
        println(firstrow(ind))
        println("\n")
    }
    ```

3. Prepare the DataFrame for Machine Learning

    Do the next:
   * Rename the column "Clicked on Ad" to "label"
   * Take the following columns as features "Daily Time Spent on Site", "Age", "Area Income", "Daily Internet Usage", "Timestamp", "Male"
   * Create a new column called "Hour" from the Timestamp containing the "Hour of the click"

    ```scala
    val timedata = data.withColumn("Hour",hour(data("Timestamp")))

    val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")
    ```
    Import VectorAssembler and Vectors
    Create a new VectorAssembler object called assembler for the features
    ```scala
    import org.apache.spark.ml.feature.VectorAssembler
    import org.apache.spark.ml.linalg.Vectors

    val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))
    ```
    Use randomSplit to create 70/30 split test and train data
    ```scala
    val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
    ```

4. Set up a Pipeline
    Pipeline amount
    Create a new LogisticRegression object called lr
    Create a new pipeline with the elements: assembler, lr
    Fit (fit) the pipeline for the training set.
    Take the Results in the Test set with transform
    ```scala
    import org.apache.spark.ml.Pipeline
    val lr = new LogisticRegression()
    
    val pipeline = new Pipeline().setStages(Array(assembler, lr))
    val model = pipeline.fit(training)
    val results = model.transform(test)
    ```

5. Model evaluation
    For Metrics and Evaluation import MulticlassMetrics
    Convert test results to RDD using .as and .rdd
    Initialize a MulticlassMetrics object
    Print the Confusion matrix
    ```scala
    import org.apache.spark.mllib.evaluation.MulticlassMetrics

    val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
    val metrics = new MulticlassMetrics(predictionAndLabels)

    println("Confusion matrix:")
    println(metrics.confusionMatrix)

    metrics.accuracy
