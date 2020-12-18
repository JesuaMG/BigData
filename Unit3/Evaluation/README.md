# Evaluation Practice Unit 3

### K-means

1. Import a simple Spark session.
```scala
import org.apache.spark.sql.SparkSession
```

2. Use lines of code to minimize errors
```scala

```

3. Create an instance of the Spark session
```scala
val spark = SparkSession.builder().getOrCreate()
```

4. Import the Kmeans library for the clustering algorithm.
```scala

```

5. Load the Wholesale Customers Data dataset
```scala
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale_customers_data.csv")
dataset.show
```

6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data
```scala

```

7. Import Vector Assembler and Vector
```scala
import org.apache.spark.ml.feature.VectorAssembler
```

8. Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
```scala

```

9. Use the assembler object to transform feature_data
```scala
val  features = assembler.transform(feature_data)
features.show
```

10. Create a Kmeans model with K = 3
```scala

```

11. Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
```scala
val WSSSE = model.computeCost(features)
println(s"Within Set Sum of Squared Errors = $WSSSE")

println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```
