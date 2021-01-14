// LINEAR REGRESSION EXERCISE

// Practice #1

// 1. Import LinearRegression
import org.apache.spark.ml.regression.LinearRegression

     // Optional: Use the following code to configure errors
     import org.apache.log4j._
     Logger.getLogger("org").setLevel(Level.ERROR)

// 2. Start a simple Spark Session
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

// 3. Use Spark for the Clean-Ecommerce csv file.
val data = spark.read.option("header", "true").option("inferSchema","true")csv("Clean-Ecommerce.csv")

// 4. Print the schema in the DataFrame.
data.printSchema()

// 5. Print an example row from the DataFrame.
data.head(1)

////////////////////////////////////////////////////// ////
//// Configure the DataFrame for Machine Learning ////
////////////////////////////////////////////////////// ////

// 1. Transform the data frame to take the form of ("label", "features")
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}

// 2. Import VectorAssembler and Vectors
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// 3. Rename the column Yearly Amount Spent as "label"
//    Also from the data take only the numerical column
//    Leave all this as a new DataFrame called df
val df = data.select(data("Price").as("label"), $"Avg Area Income", $"Avg Area House Age", $"Avg Area Number of Rooms", $"Avg Area Number of Bedrooms", $"Area Population")

// 4. Let the assembler object convert the input values ​​to a vector
val assembler = new VectorAssembler().setInputCols(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms", "Avg Area Number of Bedrooms", "Area Population")).setOutputCol("features")

// 5. Use the VectorAssembler object to convert the input columns of the df
//    to a single output column of an array named "features"
//    Set the input columns from where we are supposed to read the values.
//    Call this new assambler.
//    Use the assembler to transform our DataFrame to two columns: label and features
val assembler = new VectorAssembler().setInputCol(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms", "Avg Area Number of Bedrooms", "Area Population"))
val output = assembler.transform(df).select($"label", $"features")
output.show()

// 6. Create an object for a linear regression model.
val lr = new LinearRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.8)

// 7. Fit the model for the data and call this model lrModel
val lrModel = lr.fit(training)

// 8. Print the coefficients and intercept for the linear regression
println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

// 9. Summarize the model on the training set print the output of some metrics!
//    Use our model's .summary method to create an object
//    called trainingSummary.
val trainingSummary = lrModel.summary
println(s"numIterations: ${trainingSummary.totalIterations}")
println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}")

// 10. Show the values ​​of residuals, the RMSE, the MSE, and also the R ^ 2.
trainingSummary.residuals.show()
println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
println(s"r2: ${trainingSummary.r2}")
println(s"RMSE: ${trainingSummary.MeanSquaredError}")