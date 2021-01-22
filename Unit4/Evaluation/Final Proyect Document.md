<html>
<h2 align="center" > Final Project Document</h2>

<div  align="center" >

![ScreenShot](https://github.com/JesuaMG/git_flow/blob/Features/portada.png)

</div>

<h3 align="center" >Instituto Nacional de México</h3>
<h3 align="center" >Instituto Tecnológico de Tijuana</h3>
<h3 align="center" >Departamento de sistemas y computación</h3>
<br>
<h4 align="center" >Ingeniería en Sistemas Computacionales</h4>
<h4 align="center" >Semester of Sep 2020 - Ene 2021</h4>
<br>
<h3  align="center" >Datos Masivos </h3>
<br>
<h4 align="center" >Unit 4</h4>
<h4 align="center" >Final Project</h4>
<br>
<h4 align="center" >Made by : </h4>
<h4 align="center" >Hernández Negrete Juan Carlos - 16212021</h4>
<h4 align="center" >Manzano Guzmán Jesua - 16212033</h4>
<br>
<h4 align="center" >Professor : </h4>
<h4 align="center" >Dr. Jose Christian Romero Hernandez</h4>
<br>
<h4 align="center" >Delivery date: 2021 / January / 15 </h4>
</html>

## Index
- [Index](#index)
- [Introduction](#introduction)
- [Theoretical framework of algorithms](#theoretical-framework-of-algorithms)
  - [SVM](#svm)
  - [Decision Tree](#decision-tree)
  - [Logistic Regression](#logistic-regression)
  - [Multilayer Perceptron](#multilayer-perceptron)
- [Implementation](#implementation)
  - [SVM (Support Vector Machine)](#svm-support-vector-machine)
  - [Decision Tree](#decision-tree-1)
  - [Logistic Regression](#logistic-regression-1)
  - [Multilayer Perceptron](#multilayer-perceptron-1)
- [Results](#results)
- [Conclusions](#conclusions)
- [References](#references)

## Introduction

<p align = "justify">
The purpose of this document is to analyze, compare and verify the efficiency of 4 classification algorithms, which are SVM (Support Vector Machine), Decision Tree, Logistic Regresion and Multilayer Perceptron, working with the bank-full.csv dataset (https: //archive.ics.uci.edu/ml/datasets/Bank+Marketing).
<br>
To carry out the development of this project, it will be necessary to implement the knowledge acquired in the course of Big Data.


## Theoretical framework of algorithms

### SVM
<p align = "justify">
A support vector machine (SVM) is a supervised learning algorithm that can be used for binary classification or regression. Support vector machines are very popular in applications such as natural language processing, speech, image recognition, and computer vision.<br>
A support vector machine constructs an optimal hyperplane in the form of a decision surface, so that the margin of separation between the two classes in the data is maximally widened. Support vectors refer to a small subset of the training observations that are used as support for the optimal location of the decision surface. <br>
Support vector machines belong to a class of Machine Learning algorithms called kernel methods and are also known as kernel machines. 

![ScreenShot](https://github.com/JesuaMG/git_flow/blob/Features/1607682266241.jpg)

The training of a support vector machine consists of two phases:

- Transform the predictors (input data) into a highly dimensional feature space. In this phase it is enough to specify the kernel; data is never explicitly transformed into feature space. This process is commonly known as the kernel hack. 
- Solve a quadratic optimization problem that fits an optimal hyperplane to classify the transformed features into two classes. The number of transformed features is determined by the number of support vectors. 

### Decision Tree
<p align ="justify"> 
Decision tree is the most powerful and popular tool for classification and prediction. A Decision tree is a flowchart like tree structure, where each internal node denotes a test on an attribute, each branch represents an outcome of the test, and each leaf node (terminal node) holds a class label. <br><br>
Decision trees classify instances by sorting them down the tree from the root to some leaf node, which provides the classification of the instance. An instance is classified by starting at the root node of the tree,testing the attribute specified by this node,then moving down the tree branch corresponding to the value of the attribute as shown in the above figure.This process is then repeated for the subtree rooted at the new node. 
<br><br>

![ScreenShot](https://github.com/JesuaMG/git_flow/blob/Features/DT.png)

The strengths of decision tree methods are: 

- Decision trees are able to generate understandable rules.
- Decision trees perform classification without requiring much computation.
- Decision trees are able to handle both continuous and categorical variables.
- Decision trees provide a clear indication of which fields are most important for prediction or classification.


### Logistic Regression
<p align = "justify">
Logistic Regression is a Machine Learning algorithm which is used for the classification problems, it is a predictive analysis algorithm and based on the concept of probability.<br>

![ScreenShot](https://github.com/JuanCarlos-Negrete/practica_git_flow/blob/development/LR.jpeg)

We can call a Logistic Regression a Linear Regression model but the Logistic Regression uses a more complex cost function, this cost function can be defined as the ‘Sigmoid function’ or also known as the ‘logistic function’ instead of a linear function. <br>
The hypothesis of logistic regression tends it to limit the cost function between 0 and 1. Therefore linear functions fail to represent it as it can have a value greater than 1 or less than 0 which is not possible as per the hypothesis of logistic regression.<br>

![ScreenShot](https://github.com/JuanCarlos-Negrete/practica_git_flow/blob/development/LR2.png)

###### What is the Sigmoid Function?
In order to map predicted values to probabilities, we use the Sigmoid function. The function maps any real value into another value between 0 and 1. In machine learning, we use sigmoid to map predictions to probabilities.

![ScreenShot](https://github.com/JuanCarlos-Negrete/practica_git_flow/blob/development/LR3.png)

### Multilayer Perceptron
<p align = "justify">
The perceptron is very useful for classifying data sets that are linearly separable.  They encounter serious limitations with data sets that do not conform to this pattern as discovered with the XOR problem.  The XOR problem shows that for any classification of four points that there exists a set that are not linearly separable.<br>
The MultiLayer Perceptron (MLPs) breaks this restriction and classifies datasets which are not linearly separable.  They do this by using a more robust and complex architecture to learn regression and classification models for difficult datasets.<br>

###### How does a multilayer perceptron work?
The Perceptron consists of an input layer and an output layer which are fully connected.  MLPs have the same input and output layers but may have multiple hidden layers in between the aforementioned layers, as seen below.<br>

![ScreenShot](https://github.com/JuanCarlos-Negrete/practica_git_flow/blob/development/MP.jpg)

- The **input layer** consists of neurons that accept the input values. The output of these neurons is the same as that of the input predictors. The nodes in the input layer represent the input data. All other nodes map inputs to outputs by a linear combination of the inputs with the node weights w and the bias by applying an activation function. This can be written in matrix form for MLPC with K + 1 layers as follows: Input_Layer

- The **hidden layers** are between the input and output layers. Typically, the number of hidden layers varies from one to many. It is the central calculation layer that has the functions that map the input to the output of a node. The nodes of the intermediate layers use the sigmoid (logistic) function, as follows Hidden_Layer

- The **output layer** is the final layer of a neural network that returns the result to the user environment. Based on the design of a neural network, it also indicates to the previous layers how they have performed in learning information and, consequently, improved their functions. The nodes in the output layer use the softmax function. Output_Layer

The number of nodes N, in the output layer, corresponds to the number of classes.

## Implementation

<p align="justify"> To carry out this project Apache Spark was used with the Scala programming language, it was decided to use this FrameWork due to its efficiency for Big Data, in addition to the fact that it can be used with 3 different programming languages (Python, Java and Scala), it was used Scala due to the many advantages it offers such as the easy scalability of the code, it is a language based on the Object Oriented paradigms and the Functional paradigm, it can be run in Java Virtual Machine, it is also faster than Python and Java. Another advantage that we could find in Apache Spark is the documentation of this platform which allowed us to resolve doubts throughout the development of this project.


### SVM (Support Vector Machine)

Import libs
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline
``` 
Minimize errors and  start a simple Spark session.
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder.appName("svm").getOrCreate()
```
Load the bank-full.csv dataset and check the data
```scala
val df  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")

df.head()
df.describe()
```
Index column "y", Create a vector with the columns with numerical data and name it as features, Use the assembler object to transform features
```scala
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedY").fit(df)
val indexed = labelIndexer.transform(df).drop("y").withColumnRenamed("indexedY", "label")

val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

val featurestrans = vectorFeatures.transform(indexed)
```
Rename column "y" as label, Union of label and features as dataIndexed, Creation of labelIndexer and featureIndexer for the pipeline
```scala
val featureslabel = featurestrans.withColumnRenamed("y", "label")

val dataindexed = featureslabel.select("label","features")
dataindexed.show()

val labelindexer = new StringIndexer().setInputCol("label").setOutputCol("indexedlabel").fit(dataindexed)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedfeatures").setMaxCategories(4).fit(dataindexed)
```
Training data as 70% and test data as 30%.
```scala
val Array(training, test) = dataindexed.randomSplit(Array(0.7, 0.3), seed = 1234L)
```
Linear Support Vector Machine object, Fitting the trainingData into the model, Transforming testData for the predictions.
```scala
val supportVM = new LinearSVC().setMaxIter(10).setRegParam(0.1)
    
val modelSVM = supportVM.fit(training)

val predictions = modelSVM.transform(test)
```
Obtaining the metrics, Confusion matrix, Accuracy and Test Error.
```scala
val predictionAndLabels = predictions.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

println("Accuracy: " + metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")
```

### Decision Tree

Import libs
```scala
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.Pipeline
```
Minimize errors and  start a simple Spark session.
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder.appName("svm").getOrCreate()
```
Load the bank-full.csv dataset and check the data
```scala
val df  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")

df.head()
df.describe()
```
Transform categorical data to numeric, Create a vector with the columns with numerical data and name it as features, Use the assembler object to transform features
```scala
val stringindexer = new StringIndexer().setInputCol("y").setOutputCol("label")
val df = stringindexer.fit(dataframe).transform(dataframe)

val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","campaign","pdays","previous")).setOutputCol("features")
val output = assembler.transform(df)

val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(output)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(output)
```
Training data as 70% and test data as 30%
```scala
val Array(trainingData, testData) = output.randomSplit(Array(0.7, 0.3), seed = 1234L)
```
Train a model, Convert indexed labels back to original labels, Chain indexers and tree in a Pipeline
```scala
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")

val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
```
Train model, Make predictions
```scala
val model = pipeline.fit(trainingData)

val predictions = model.transform(testData)

predictions.select("predictedLabel", "label", "features").show(5)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")
```
### Logistic Regression
Import the libraries, Errors are minimized, Spark session is created
```scala
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.mllib.evaluation.MulticlassMetrics

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()
```

The dataframe is created with the CSV bank-full, Index labels, adding metadata to the label column, fit on whole dataset to include all labels in index.
```scala
val data = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(data)
val indexed = labelIndexer.transform(data).drop("y").withColumnRenamed("indexedLabel", "label")
```

The vector is created to add the fields to the array, Transformed into a new indexed variable and The label of the features field is renamed
```scala
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))
val features = vectorFeatures.transform(indexed)
val featuresLabel = features.withColumnRenamed("y", "label")
```

A new variable is created by selecting some fields, Use randomSplit to create 70/30 split test and train data, The Logistic Regression is created with the parameters sent, The logistic model is trained
```scala
val dataIndexed = featuresLabel.select("label","features")
val Array(training, test) = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 12345)
val logisticAlgorithm = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8).setFamily("multinomial")
val logisticModel = logisticAlgorithm.fit(training)
```

The precision of the test data is calculated
```scala
val results = logisticModel.transform(test)
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)
println("Confusion matrix:")
println(metrics.confusionMatrix)
```

Accuracy and error test is printed
```scala
println("Accuracy: "+metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")
```

### Multilayer Perceptron
Import the libraries, Errors are minimized, Spark session is created
```scala
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.types.IntegerType

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder.appName("MultilayerPerceptronClassifierExample").getOrCreate()
```

The dataframe is created with the CSV bank-full, The data is displayed
```scala
val dataframeMP  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("bank-full.csv")

dataframeMP.columns 
dataframeMP.printSchema() 
dataframeMP.head(5) 
dataframeMP.describe().show() 
```

Index labels, adding metadata to the label column, fit on whole dataset to include all labels in index, The assemble vector is created with the mentioned fields
```scala
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(dataframeMP)
val indexed = labelIndexer.transform(dataframeMP).drop("y").withColumnRenamed("indexedLabel", "label")
indexed.describe().show() 

val assembler = new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features")
val features = assembler.transform(indexed)
```

The label columns are indexed and the data is displayed
```scala
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(indexed)
println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")
features.show()
```

Data is divided into training and testing, The layers of the neural network are specified
```scala
val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

val layers = Array[Int](5, 4, 1, 2)
```

Training parameters are set
```scala
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
```

The model is trained
```scala
val model = trainer.fit(train)
```
The precision of the test data is calculated
```scala
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
predictionAndLabels.show
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

println(s"Test Accuracy = ${evaluator.evaluate(predictionAndLabels)}")
println(s"Test Error = ${(1.0 - evaluator.evaluate(predictionAndLabels))}")
spark.stop()
```

## Results
Accuracy
|  | **Accuracy** | **Test Error** |
| --- | --- | --- |
| SVM | 0.883770 | 0.116229 |
| Decision Three | 0.891778 | 0.108221 |
| Logistic Regression |  0.884833 | 0.115166 |
| Multilayer Perceptron | 0.882923 | 0.117076 |

## Conclusions
Compared to other units, this was somewhat simple, since, what was seen in class was applied and throughout the semester, the performance of each of them could be compared, which was the accuracy that gave us as a result, the matrix of confusion of some, and their error testing, the comparison is not very great but if we could notice the change in each of them, in summary, what was seen in the semester was applied with some practices already done and therefore, it was not so difficult to apply each of them.
<br>
## References
> Marks, R. J., Moulin, L. S., da Silva, A. A., & El-Sharkawi, M. A. (2001). Neural networks and support vector machines applied to power systems transient stability analysis. International journal of engineering intelligent systems for electrical engineering and communications, 9(4), 205-212.

> Viera, Á. F. G. (2017). Técnicas de aprendizaje de máquina utilizadas para la minería de texto. Investigación bibliotecológica, 31(71), 103-126.

> Sana, B., Siddiqui, I. F., & Arain, Q. A. (2019). Analyzing students’ academic performance through educational data mining.

> Rumelhart, David E., Geoffrey E. Hinton, and R. J. Williams. Learning Internal Representations by Error Propagation". David E. Rumelhart, James L. McClelland Parallel distributed processing: Explorations in the microstructure of cognition, Volume 1: Foundation. MIT Press, 1986

> Hastie, Trevor. Tibshirani, Robert. Friedman, Jerome. The Elements of Statistical Learning: Data Mining, Inference, and Prediction. Springer, New York, NY, 2009.

> Haykin, Simon (1998). Neural Networks: A Comprehensive Foundation (2 ed.). Prentice Hall

> R. Collobert and S. Bengio (2004). Links between Perceptrons, MLPs and SVMs. Proc. Int'l Conf. on Machine Learning (ICML).