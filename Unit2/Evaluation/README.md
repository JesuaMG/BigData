# Evaluation Practice Unit 2

### Multilayer Perceptron Classifier

1. Load in an Iris.csv dataframe found at https://github.com/jcromerohdz/iris, elaborate the necessary data to be processed by the following algorithm (Important, this cleaning must be through a Scala script in Spark).
    ```scala
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.sql.SparkSession
    import org.apache.spark.ml.feature.StringIndexer
    import org.apache.spark.ml.feature.VectorAssembler
    ```

    ###### a) Use the Spark Mllib library the Machine Learning algorithm corresponding to multilayer perceptron
    ```scala
    val df = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")
    ```

2. What are the column names?


3. How is the scheme?   
    ````scala  
    val esquema = df.printSchema
    df.printSchema
    ```
    
4. Print the first 5 columns.


5. Use the describe () method to learn more about the data in the DataFrame.

    ```scala
    val desc = df.describe().show()
    df.describe().show() 
    ```

6. Make the relevant transformation for the categorical data which will be our labels to be classified.

7. Build the classification model and explain its architecture.
    
    Data is divided into training (60%) and testing (30%)
    ```scala
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
    ```

    The layers of the neural network are specified:
    The input layer is size 4 (characteristics), two intermediate layers one size 7 and the other size 7 and 3 out (the classes) 
    ```scala
    val layers = Array[Int](4, 7, 7, 3)
    ```
    Training parameters are set
    ```scala
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)
    ```

    The model is trained
    ```scala
    val model = trainer.fit(train)
    ```
    
8. Print model results