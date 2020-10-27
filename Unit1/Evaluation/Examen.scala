import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//1 Start a simple Spark session.
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

//2 Upload Netflix Stock CSV file, have Spark infer data types.
val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")

//3 What are the names of the columns?
df.columns

//4 What is the scheme like?
df.printSchema()

//5 Print the first 5 columns.
df.head(5)

//6 Use describe () to learn about the DataFrame.
df.describe().show()

/*7 Create a new dataframe with a new column called “HV Ratio” which is the relationship 
    between the price in the “High” column versus the “Volume” column of shares traded for a day. 
    (Hint: It is a column operation).*/

val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))

//8 What day had the highest peak in the “Close” column?
df.orderBy($"High".desc).show(1)
//9 Write in your own words in a comment of your code. What is the meaning of the Close column "Close"?
// It is the value with is that it was closed that day

//10 What is the maximum and minimum of the “Volume” column?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

import spark.implicits._

//11 a) How many days was the “Close” column less than $ 600?
val result = df.filter($"Close" < 600).count()

//11 b) What percentage of the time was the “High” column greater than $ 500?
val result = (df.filter($"High" > 500).count())*1.0/df.count()*100

//11 c) What is the Pearson correlation between column "High" and column "Volume"?
df.select(corr("High", "Volume")).show()

//11 d) What is the maximum in the “High” column per year?
val df2 = df.withColumn("Year", year(df("Date")))
val df3 = df2.select($"Year", $"High").groupBy("Year").max()
df3.select($"Year", $"max(High)").show()

//11 e) What is the “Close” column average for each calendar month?
val df2 = df.withColumn("Month", month(df("Date")))
val df3 = df2.select($"Month", $"Close").groupBy("Month").mean()
df3.select($"Month", $"avg(Close)").show()
