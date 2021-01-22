# Practice #5 
### RANDOM FOREST

1. Import libs
    ```scala 
    import org.apache.spark.ml.Pipeline
    import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
    import org.apache.spark.ml.attribute.Attribute
    ```
2. Load and parse the data file, converting it to a DataFrame.
    ```scala
    val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
    ```
3. Index labels, adding metadata to the label column. Fit on whole dataset to include all labels in index.
    ```scala
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
    val indexed =  labelIndexer.transform(data)
    ```
4. Automatically identify categorical features, and index them. Set maxCategories so features with > 4 distinct values are treated as continuous.
    ```scala
    val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
    ```
5. Split the data into training and test sets (30% held out for testing).
    ```scala
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
    ```
6. Train a RandomForest model.
    ```scala
    val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)
    ```
7. Convert indexed labels back to original labels.
    ```scala
    val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels) 
    ```
8. Chain indexers and forest in a Pipeline.
    ```scala
    val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))
    ```
9. Train model. This also runs the indexers.
    ```scala
    val model = pipeline.fit(trainingData)
    ```
10. Make predictions.
    ```scala
    val predictions = model.transform(testData)
    ```
11. Select example rows to display.
    ```scala
    predictions.select("predictedLabel", "label", "features").show(5)
    ```
12. Select (prediction, true label) and compute test error.
    ```scala
    val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
    val accuracy = evaluator.evaluate(predictions)
    println(s"Test Error = ${(1.0 - accuracy)}")

    val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]

    println(s"Learned classification forest model:\n ${rfModel.toDebugString}")
    ```

