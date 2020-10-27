# Evaluation Practice Unit 1
```scala
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
```
## Number #1
### Start a simple Spark session.
The entry point into all functionality in Spark is the SparkSession class. To create a basic SparkSession, just use ```scala SparkSession.builder(): ```

```scala

scala> import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.SparkSession

scala> val spark = SparkSession.builder().getOrCreate()

spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@69e8f7a5
```

## Number #2
### Upload Netflix Stock CSV file, have Spark infer data types.
With a SparkSession, applications can create DataFrames from an existing RDD, from a Hive table, or from Spark data sources. In this case, we will take the CSV file "Netflix_2011_2016.csv"

```scala
scala> val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

df: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 5 more fields]
```

## Number #3
### What are the names of the columns?
The column names are: Date, Open, High, Low, Close, Volume and Adj Close

```scala
scala> df.columns

res0: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
```

## Number #4
### What is the scheme like?
In order to know the structure of the schema of our dataframe we will use printSchema that will describe the type of each of our fields in the dataframe

```scala
scala> df.printSchema()

root
 |-- Date: timestamp (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)

```

## Number #5
### Print the first 5 columns.
With head we print the first 5 values of our dataframe as an array

```scala
scala> df.head(5)

res2: Array[org.apache.spark.sql.Row] = Array([2011-10-24 00:00:00.0,119.100002,120.28000300000001,115.100004,118.839996,120460200,16.977142], [2011-10-25 00:00:00.0,74.899999,79.390001,74.249997,77.370002,315541800,11.052857000000001], [2011-10-26 00:00:00.0,78.73,81.420001,75.399997,79.400002,148733900,11.342857], [2011-10-27 00:00:00.0,82.179998,82.71999699999999,79.249998,80.86000200000001,71190000,11.551428999999999], [2011-10-28 00:00:00.0,80.280002,84.660002,79.599999,84.14000300000001,57769600,12.02])
```

## Number #6 
### Use describe () to learn about the DataFrame.
The average, column count, minimum and maximum, etc. of our dataframe are described below

```scala
df.describe().show()
```

## Number #7
### Create a new dataframe with a new column called “HV Ratio” which is the relationship between the price in the “High” column versus the “Volume” column of shares traded for a day. (Hint: It is a column operation).
The calculation of the operation between HIGH and VOLUME is carried out where high will be the highest point that was had depending on the date where we will have to divide it by the volume to be able to know the average of the sale that was with the stock that we have

```scala
val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
```

## Number #8
### What day had the highest peak in the “Close” column?
All the high values are grouped within the dataframe where they will be displayed in descending order, in order to show the highest value first and only be able to show the first value of the dataframe

```scala
df.orderBy($"High".desc).show(1)
```

## Number #9 
### Write in your own words in a comment of your code. What is the meaning of the Close column "Close"?
In relation to the dataframe with the CSV, they are stock values or records where the date of their registration is taken into account, where the entry and exit of these can be considered with OPEN and CLOSE, that is, how many there were before and after , like HIGH and LOW which would be the highest and lowest stock.

## Number #10
### What is the maximum and minimum of the “Volume” column?
```scala
df.select(max("Volume")).show()

+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+

df.select(min("Volume")).show()

+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+
```

## Number #11
### With Scala / Spark $ Syntax answer the following:                                                           Hint: Basically very similar to the dates session, you will have to create another dataframe to answer some of the items.

```scala
import spark.implicits._
```

## a)
### How many days was the “Close” column less than $ 600?
```scala
val result = df.filter($"Close" < 600).count()

result: Long = 1218
```

## b) 
### What percentage of the time was the “High” column greater than $ 500?
```scala
val result = (df.filter($"High" > 500).count())*1.0/df.count()*100

result: Double = 4.924543288324067
```

## c) 
### What is the Pearson correlation between column "High" and column "Volume"?
```scala
df.select(corr("High", "Volume")).show()

+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+
```

## d) 
### What is the maximum in the “High” column per year?
```scala
val df2 = df.withColumn("Year", year(df("Date")))
val df3 = df2.select($"Year", $"High").groupBy("Year").max()
df3.select($"Year", $"max(High)").show()

+----+------------------+                                                       
|Year|         max(High)|
+----+------------------+
|2015|        716.159996|
|2013|        389.159988|
|2014|        489.290024|
|2012|        133.429996|
|2016|129.28999299999998|
|2011|120.28000300000001|
+----+------------------+

```

## e) 
### What is the “Close” column average for each calendar month?
```scala
val df2 = df.withColumn("Month", month(df("Date")))
val df3 = df2.select($"Month", $"Close").groupBy("Month").mean()
df3.select($"Month", $"avg(Close)").show()

+-----+------------------+                                                      
|Month|        avg(Close)|
+-----+------------------+
|   12| 199.3700942358491|
|    1|212.22613874257422|
|    6| 295.1597153490566|
|    3| 249.5825228971963|
|    5|264.37037614150944|
|    9|206.09598121568627|
|    4|246.97514271428562|
|    8|195.25599892727263|
|    7|243.64747528037387|
|   10|205.93297300900903|
|   11| 194.3172275445545|
|    2| 254.1954634020619|
+-----+------------------+

```