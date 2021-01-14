# Practice #1
### K-means

1. Start a Spark Session.
```scala
import org.apache.spark.sql.SparkSession
```

2. Optional: Use the following code below to set the Error reporting.
```scala
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

3. Spark Session.
```scala
val spark = SparkSession.builder().getOrCreate()
```

4. Import clustering Algorithm.
```scala
import org.apache.spark.ml.clustering.KMeans
```

5. Loads data.
```scala
val dataset = spark.read.format("libsvm").load("sample_kmeans_data.txt")
```

6. Trains a k-means model.
```scala
val kmeans = new KMeans().setK(2).setSeed(1L)
val model = kmeans.fit(dataset)
```

7. Evaluate clustering by computing Within Set Sum of Squared Errors.
```scala
val WSSSE = model.computeCost(dataset)
println(s"Within Set Sum of Squared Errors = $WSSSE")
```

8. Shows the result.
```scala
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```
