// Evaluation Unit 2
// K-MEANS

// 1. Import a simple Spark session.
import org.apache.spark.sql.SparkSession

// 2. Use lines of code to minimize errors


// 3. Create an instance of the Spark session
val spark = SparkSession.builder().getOrCreate()

// 4. Import the Kmeans library for the clustering algorithm.


// 5. Load the Wholesale Customers Data dataset
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("Wholesale_customers_data.csv")
dataset.show()

// 6. Select the following columns: Fresh, Milk, Grocery, Frozen, Detergents_Paper, Delicassen and call this set feature_data


// 7. Import Vector Assembler and Vector
import org.apache.spark.ml.feature.VectorAssembler

// 8. Create a new Vector Assembler object for the feature columns as an input set, remembering that there are no labels
// 9. Use the assembler object to transform feature_data
val  features = assembler.transform(feature_data)
features.show()

// 10. Create a Kmeans model with K = 3


// 11. Evaluate the groups using Within Set Sum of Squared Errors WSSSE and print the centroids.
val WSSSE = model.computeCost(features)
println(s"Within Set Sum of Squared Errors = $WSSSE")

println("Cluster Centers: ")
model.clusterCenters.foreach(println)
