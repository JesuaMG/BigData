// Use the Spark Mllib library the Machine Learning algorithm corresponding to multilayer perceptron
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler

object Evaluation {

  def main(): Unit = {
    val spark = SparkSession.builder.appName("Evaluation").getOrCreate()

    // 1. Use the Spark Mllib library the Machine Learning algorithm corresponding to multilayer perceptron
    val df = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")

    // 2. What are the column names?
    df.columns

    // 3. How is the scheme?     
    val esquema = df.printSchema
    df.printSchema
    
    // 4. Print the first 5 columns.
    df.head(5)

    // 5. Use the describe () method to learn more about the data in the DataFrame.
    val desc = df.describe().show()
    df.describe().show() 

    // 6. Make the relevant transformation for the categorical data which will be our labels to be classified.
    val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(df)
    val indexed = labelIndexer.transform(df).drop("species").withColumnRenamed("indexedLabel", "label")
    indexed.describe().show()

    // 7. Build the classification model and explain its architecture.
    
    val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")
    val  features = assembler.transform(indexed)
    val labelIndexer2 = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(indexed)
    println(s"Found labels: ${labelIndexer2.labels.mkString("[", ", ", "]")}")
    
    features.show

    // Data is divided into training (60%) and testing (30%)
    val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)

    // The layers of the neural network are specified:
    // The input layer is size 4 (characteristics), two intermediate layers
    // one size 7 and the other size 7
    // and 3 out (the classes)
    val layers = Array[Int](4, 7, 7, 3)
    // Test set accuracy = 0.9607843137254902 (4, 5, 4, 3), (4, 8, 8, 3)
    // Test set accuracy = 0.9803921568627451 (4, 9, 9, 3), (4, 7, 7, 3)

    // Training parameters are set
    val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

    // The model is trained
    val model = trainer.fit(train)
    val result = model.transform(test)

    // 8. Print model results

    val predictionAndLabels = result.select("prediction", "label")
    predictionAndLabels.show()

    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
    
    spark.stop()
  }
}