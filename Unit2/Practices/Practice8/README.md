# Practice #8
### Linear Support Vector Machine

1. Importing the Libraries
```scala
import org.apache.spark.ml.classification.LinearSVC
```
2. Load training data
```scala
val training = spark.read.format("libsvm").load("C:/Users/DELL/Desktop/LSVMExample/sample_libsvm_data.txt")

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)
```

3. Fit the model
```scala
val lsvcModel = lsvc.fit(training)
```

4. Print the coefficients and intercept for linear svc
```scala
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")

:load svmexample.scala
```
