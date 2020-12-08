# Practice #10
### Naive Bayes

1. Import Libraries
```scala
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```

2. Load the data saved in LIBSVM format as a DataFrame.
```scala
val data = spark.read.format("libsvm").load("C:/Users/Sebas/Desktop/sample_libsvm_data.txt")
data.show(2)
```

3. Separate data into training and test sets (30% reserved for testing)
```scala
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)
```

4. Train a Naive Bayes model.
```scala
val model = new NaiveBayes().fit(trainingData)
```

5. Select the sample rows to display.
```scala
val predictions = model.transform(testData)
predictions.show()
```

6. Select (prediction, true label) and calculate test errors
```scala
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)

println(s"Test set accuracy = $accuracy")
```