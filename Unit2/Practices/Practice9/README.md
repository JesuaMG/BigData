# Practice #9
### One-vs-Rest classifier

1. Import the libraries
    ```scala
    import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    ```
2. Upload data file.
    ```scala
    var inputData = spark.read.format("libsvm").load("/opt/spark/data/mllib/sample_multiclass_classification_data.txt")
    ```
3. Generate the train / test division.
    ```scala
    val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))
    ```
4. Instantiate base classifier
    ```scala
    val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)
    ```
5. Create an instance of the One Vs Rest classifier.
    ```scala
    val ovr = new OneVsRest().setClassifier(classifier)
    ```
6. Train the multiclass model.
    ```scala
    val ovrModel = ovr.fit(train)
    ```
7. Score the model on the test data.
    ```scala
    val predictions = ovrModel.transform(test)
    ```
8. Get evaluator.
    ```scala
    val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
    ```
9. Calculates the classification error in the test data.
    ```scala
    val accuracy = evaluator.evaluate(predictions)
    println(s"Test Error = ${1 - accuracy}")
    ```


