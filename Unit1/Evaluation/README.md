# Evaluation Practice Unit 1

import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

## Number #1
### Start a simple Spark session.

## Number #2
### Upload Netflix Stock CSV file, have Spark infer data types.

## Number #3
### What are the names of the columns?

## Number #4
### What is the scheme like?

## Number #5
### Print the first 5 columns.

## Number #6 
### Use describe () to learn about the DataFrame.

## Number #7
### Create a new dataframe with a new column called “HV Ratio” which is the relationship between the price in the “High” column versus the “Volume” column of shares traded for a day. (Hint: It is a column operation).

## Number #8
### What day had the highest peak in the “Close” column?

## Number #9 
### Write in your own words in a comment of your code. What is the meaning of the Close column "Close"?
It is the value with is that it was closed that day

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