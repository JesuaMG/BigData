// Final Project
// Logistic Regression

// Import the libraries
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.mllib.evaluation.MulticlassMetrics

// Errors are minimized
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Spark session is created
val spark = SparkSession.builder().getOrCreate()

// The dataframe is created with the CSV bank-full
val data = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")

// Index labels, adding metadata to the label column, fit on whole dataset to include all labels in index.
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).drop("y").withColumnRenamed("indexedLabel", "label")

// The vector is created to add the fields to the array
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

// The vector is transformed into a new indexed variable
val features = vectorFeatures.transform(indexed)

// The label of the features field is renamed
val featuresLabel = features.withColumnRenamed("y", "label")

// A new variable is created by selecting some fields
val dataIndexed = featuresLabel.select("label","features")

// Use randomSplit to create 70/30 split test and train data
val Array(training, test) = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 12345)

// The Logistic Regression is created with the parameters sent
val logisticAlgorithm = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFamily("multinomial")

// The logistic model is trained
val logisticModel = logisticAlgorithm.fit(training)

// The precision of the test data is calculated
val results = logisticModel.transform(test)
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

// The confusion matrix is displayed
println("Confusion matrix:")
println(metrics.confusionMatrix)

// Accuracy and error test is printed
println("Accuracy: "+metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")
