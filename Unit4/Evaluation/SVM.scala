// Final Proyect 
// SVM (Support Vector Machines)

//Import libs
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline

//Minimize errors
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Spark session.
val spark = SparkSession.builder.appName("svm").getOrCreate()

//Load the bank-full.csv dataset
val df  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")
df.head()
df.describe()

//Index column "y"
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedY").fit(df)
val indexed = labelIndexer.transform(df).drop("y").withColumnRenamed("indexedY", "label")

//Create a vector with the columns with numerical data and name it as features
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Use the assembler object to transform features
val featurestrans = vectorFeatures.transform(indexed)

//Rename column "y" as label
val featureslabel = featurestrans.withColumnRenamed("y", "label")

//Union of label and features as dataIndexed.
val dataindexed = featureslabel.select("label","features")
dataindexed.show()

//Creation of labelIndexer and featureIndexer for the pipeline, Where features with distinct values > 4, are treated as continuous.
val labelindexer = new StringIndexer().setInputCol("label").setOutputCol("indexedlabel").fit(dataindexed)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedfeatures").setMaxCategories(4).fit(dataindexed)

//Training data as 70% and test data as 30%.
val Array(training, test) = dataindexed.randomSplit(Array(0.7, 0.3), seed = 1234L)

//Linear Support Vector Machine object.
val supportVM = new LinearSVC().setMaxIter(10).setRegParam(0.1)
    
//Fitting the trainingData into the model.
val modelSVM = supportVM.fit(training)

//Transforming testData for the predictions.
val predictions = modelSVM.transform(test)
predictions.show()

//Obtaining the metrics.
val predictionAndLabels = predictions.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

//Confusion matrix.
println("Confusion matrix:")
println(metrics.confusionMatrix)

// Confusion matrix:
// 11998.0  29.0  
// 1553.0   31.0

//Accuracy and Test Error.
println("Accuracy: " + metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")

// Accuracy: 0.8837704797590185
// Test Error = 0.11622952024098154
