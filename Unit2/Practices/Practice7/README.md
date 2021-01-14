# Practice #7
### Multilayer Perceptron Classifier

1. MultilayerPerceptronClassifier and MulticlassClassificationEvaluator are imported
    ```scala
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.sql.SparkSession
    ```
2. Creation of the MultilayerPerceptronClassifier object
    ```scala
    object MultilayerPerceptronClassifierExample {
    ```
3. The main function is defined, the SparkSession class object is created, and the app is given the name of MultilayerPerceptronClassifierExample
    ```scala
    def main(): Unit = {
    val spark = SparkSession
      .builder
      .appName("MultilayerPerceptronClassifierExample")
      .getOrCreate()
    ```
4. The data in libsvm format is loaded from the file as a DataFrame
    ```scala
    val data = spark.read.format("libsvm")
      .load("sample_multiclass_classification_data.txt")
    ```
5. Data is divided into training and testing
    ```scala
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
    ```
6. The layers of the neural network are specified:
    ```scala
    val layers = Array[Int](4, 5, 4, 3)
    ```
7. Training parameters are set
    ```scala
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)
    ```
8. The model is trained
    ```scala
    val model = trainer.fit(train)
    ```
9. The precision of the test data is calculated
    ```scala
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")
    val evaluator = new MulticlassClassificationEvaluator()
      .setMetricName("accuracy")
    ```
10. The model accuracy is printed
    ```scala
    println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
    ```


