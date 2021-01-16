# Practice #3 
### Basic Statistics

#### Chi Square Test Example
1. Import libs
   ```scala
    import org.apache.spark.ml.linalg.{Vector, Vectors}
    import org.apache.spark.ml.stat.ChiSquareTest
    import org.apache.spark.ml.linalg.{Matrix, Vectors}
    import org.apache.spark.ml.stat.Correlation
    import org.apache.spark.sql.Row
    import org.apache.spark.ml.stat.Summarizer
    import org.apache.spark.sql.SparkSession
    ```
2. Creating the main function
    ```scala
    object ChiSquareTestExample {
    def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("ChiSquareTestExample")
      .getOrCreate()
    import spark.implicits._
    ```
3. Declare a value of name data to which a sequence of dense vectors is assigned
    ```scala
    val data = Seq(
      (0.0, Vectors.dense(0.5, 10.0)),
      (0.0, Vectors.dense(1.5, 20.0)),
      (1.0, Vectors.dense(1.5, 30.0)),
      (0.0, Vectors.dense(3.5, 30.0)),
      (0.0, Vectors.dense(3.5, 40.0)),
      (1.0, Vectors.dense(3.5, 40.0))
    )
    ```
4. A new dataframe is created to which the data value is assigned in the label and features columns
    ```scala
    val df = data.toDF("label", "features")
    ```
5. A chi value is created to which ChiSquare is applied through the libraries
    ```scala
    val chi = ChiSquareTest.test(df, "features", "label").head 
    println(s"pValues = ${chi.getAs[Vector](0)}")
    println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
    println(s"statistics ${chi.getAs[Vector](2)}")
    ```
#### Correlation Example
1. Creating the main function 
    ```scala
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("CorrelationExample")
      .getOrCreate()
    import spark.implicits._
    ```
2.  A value called data is created to which a sequence of vectors is assigned as value
    ```scala
    val data = Seq(
      Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))), (0,3,1,-2)
      Vectors.dense(4.0, 5.0, 0.0, 3.0),
      Vectors.dense(6.0, 7.0, 0.0, 8.0),
      Vectors.sparse(4, Seq((0, 9.0), (3, 1.0))) (0,3,9,1)
    )
    ```
3. A dataframe is created which is assigned the value of a Tuple called Tuple1, the data frame contains a column called features
    ```scala
    val df = data.map(Tuple1.apply).toDF("features")
    ```
4. A Row type value called coefficient1 of a matrix is assigned the value of the pearson correlation applied to the dataframe
    ```scala
    val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
    ```
5. It is printed
    ```scala
    println(s"Pearson correlation matrix:\n $coeff1") 
    ```
6. A Row type value called coefficient2 of a matrix is assigned the value of the spearman correlation applied to the dataframe Applied to the column features
    ```scala
    val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
    println(s"Spearman correlation matrix:\n $coeff2") //Se imprime
    ```scala

#### Summarizer Example

1. Creating the main function
    ```scala
    object SummarizerExample {
    def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("SummarizerExample")
      .getOrCreate()
    import spark.implicits._
    ```scala
2. Import Summarizer 
    ```scala
    import Summarizer._
    ```
3. Data value will contain two vectors
    ```scala
    val data = Seq(
      (Vectors.dense(2.0, 3.0, 5.0), 1.0),
      (Vectors.dense(4.0, 6.0, 7.0), 2.0)
    )
    ```
4. Df value to refer to "Feactures" and "weight" 
    ```scala
    val df = data.toDF("features", "weight")
    ```
5. Two values for the mean and variance, Select the metrics (Mean, Variance)
    ```scala
    val (meanVal, varianceVal) = df.select(metrics("mean", "variance")
    ```
6. Summary method that we will apply to Feactures and Weight and give it an alias
    ```scala
      .summary($"features", $"weight").as("summary"))
    ```
7. We select the Summary with its respective metric
    ```scala
      .select("summary.mean", "summary.variance")
    ```
8. We give you the way we want to print
    ```scala
      .as[(Vector, Vector)].first()
    ```
9. We send to printing to show the values of the Mean and Variance
    ```scala
    println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")
    ```
10. Second Value without using the Summary method
    ```scala
    val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
      .as[(Vector, Vector)].first()
    println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
    ```


