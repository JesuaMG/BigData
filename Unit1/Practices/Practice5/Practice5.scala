// Functions with dataframes

// PRACTICE #5

//To develop this practice, the CitiGroup 2006_2008 DataSet was used
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

// Number #1
// Displays the top 20 rows of Dataset in a tabular form.
df.show()

+-------------------+-----+-----+-----+-----+-------+
|               Date| Open| High|  Low|Close| Volume|
+-------------------+-----+-----+-----+-----+-------+
|2006-01-03 00:00:00|490.0|493.8|481.1|492.9|1537660|
|2006-01-04 00:00:00|488.6|491.0|483.5|483.8|1871020|
|2006-01-05 00:00:00|484.4|487.8|484.0|486.2|1143160|
|2006-01-06 00:00:00|488.8|489.0|482.0|486.2|1370250|
|2006-01-09 00:00:00|486.0|487.4|483.0|483.9|1680740|
|2006-01-10 00:00:00|483.0|485.5|480.8|485.4|1365960|
|2006-01-11 00:00:00|495.8|495.8|485.8|489.8|1684440|
|2006-01-12 00:00:00|491.0|491.0|488.8|490.3|1230060|
|2006-01-13 00:00:00|491.0|491.9|487.3|489.2| 940930|
|2006-01-17 00:00:00|485.1|487.0|482.7|484.3|1237830|
|2006-01-18 00:00:00|484.3|486.7|481.1|483.8|1218910|
|2006-01-19 00:00:00|485.6|485.8|477.0|479.4|1696500|
|2006-01-20 00:00:00|472.1|474.0|456.3|456.9|4781930|
|2006-01-23 00:00:00|460.0|463.8|457.0|460.0|2025500|
|2006-01-24 00:00:00|462.9|463.6|459.9|460.1|2083740|
|2006-01-25 00:00:00|461.4|463.7|460.1|462.3|1591940|
|2006-01-26 00:00:00|465.5|475.5|464.5|470.1|1988600|
|2006-01-27 00:00:00|470.1|473.7|466.0|468.7|1412760|
|2006-01-30 00:00:00|468.7|469.9|466.6|468.2|1057630|
|2006-01-31 00:00:00|468.3|470.5|465.5|465.8|1887280|
+-------------------+-----+-----+-----+-----+-------+
only showing top 20 rows

// Number #2
// Describe certain basic values based on the fields or parameters sent as Average, Minimum, Maximum, etc.
df.describe("high", "close", "volume").show

+-------+-----------------+------------------+-----------------+
|summary|             high|             close|           volume|
+-------+-----------------+------------------+-----------------+
|  count|              755|               755|              755|
|   mean|390.6590596026489| 385.3421456953643|6308596.382781457|
| stddev|148.5151130063523|149.83310074439177| 8099892.56297633|
|    min|             55.3|              37.7|           632860|
|    max|            570.0|             564.1|        102869289|
+-------+-----------------+------------------+-----------------+

// Number #3
// Returns a Java list that contains all rows in this Dataset.
df.collectAsList()

res84: java.util.List[org.apache.spark.sql.Row] = 
    [[2006-01-03 00:00:00.0,490.0,493.8,481.1,492.9,1537660], 
    [2006-01-04 00:00:00.0,488.6,491.0,483.5,483.8,1871020], 
    [2006-01-05 00:00:00.0,484.4,487.8,484.0,486.2,1143160], 
    [2006-01-06 00:00:00.0,488.8,489.0,482.0,486.2,1370250], 
    [2006-01-09 00:00:00.0,486.0,487.4,483.0,483.9,1680740], 
    [2006-01-10 00:00:00.0,483.0,485.5,480.8,485.4,1365960], 
    [2006-01-11 00:00:00.0,495.8,495.8,485.8,489.8,1684440], 
    [2006-01-12 00:00:00.0,491.0,491.0,488.8,490.3,1230060], 
    [2006-01-13 00:00:00.0,491.0,491.9,487.3,489.2,940930], 
    [2006-01-17 00:00:00.0,485.1,487.0,482.7,484.3,1237830], 
    [2006-01-18 00:00:00.0,484.3,486.7,481.1,483.8,1218910], 
    [2006-01-19 00:00:00.0,485.6,485.8,477.0,479.4,1696500], 
    [2006-01-20 00:00:00.0,472.1,474.0,456.3,456.9,4781930]]

// Number #4
// Returns the first value of the first row
df.first()

res85: org.apache.spark.sql.Row = [2006-01-03 00:00:00.0,490.0,493.8,481.1,492.9,1537660]

// Number #5
// Returns the first 5 values of the head
df.head(5).show()

res88: Array[org.apache.spark.sql.Row] = Array([2006-01-03 00:00:00.0,490.0,493.8,481.1,492.9,1537660], 
    [2006-01-04 00:00:00.0,488.6,491.0,483.5,483.8,1871020], [2006-01-05 00:00:00.0,484.4,487.8,484.0,486.2,1143160], 
    [2006-01-06 00:00:00.0,488.8,489.0,482.0,486.2,1370250], [2006-01-09 00:00:00.0,486.0,487.4,483.0,483.9,1680740])

// Number #6
// Returns the number of rows in the Dataset.
df.count()

res89: Long = 755

// Number #7
// Returns a new Dataset that contains only the unique rows from this Dataset.
df.distinct().show()

+-------------------+-----+------+-----+-----+--------+
|               Date| Open|  High|  Low|Close|  Volume|
+-------------------+-----+------+-----+-----+--------+
|2006-04-06 00:00:00|480.6| 481.7|476.6|478.5| 1183450|
|2007-01-03 00:00:00|556.6| 562.8|547.2|552.5| 2282110|
|2007-03-22 00:00:00|519.0| 522.0|516.9|518.4| 2173338|
|2007-04-25 00:00:00|529.9| 539.4|527.8|538.0| 2675362|
|2008-04-04 00:00:00|244.4| 245.0|235.2|240.8| 7337526|
|2006-11-28 00:00:00|496.5| 498.5|494.3|495.6| 1455850|
|2007-11-09 00:00:00|321.0| 344.7|316.0|331.0|15395395|
|2008-06-19 00:00:00|205.0| 207.1|194.1|201.7|15180170|
|2006-08-25 00:00:00|487.3| 488.0|485.0|486.4|  797180|
|2007-04-05 00:00:00|512.1| 517.6|510.5|515.7| 1033954|
|2007-07-02 00:00:00|513.0| 517.5|510.1|516.4| 1806134|
|2006-03-07 00:00:00|458.5| 464.4|458.0|464.0| 1560380|
|2006-05-04 00:00:00|498.5| 498.8|492.6|493.8| 1721280|
|2006-05-10 00:00:00|501.0| 505.7|500.0|503.0| 1591700|
|2008-05-16 00:00:00|238.1| 238.1|230.8|231.2| 6731609|
|2006-09-06 00:00:00|492.1| 492.7|489.1|491.3| 1041370|
|2006-10-25 00:00:00|504.0| 509.3|504.0|508.7| 1416920|
|2007-10-01 00:00:00|458.9| 482.3|458.6|477.2| 5676675|
|2008-01-17 00:00:00|265.2| 275.7|246.0|249.6|23230520|
|2008-09-12 00:00:00|181.9|188.85|177.2|179.6|10991610|
+-------------------+-----+------+-----+-----+--------+
only showing top 20 rows

// Number #8
// It is used to be able to filter the value to be searched with a field
df.where("Volume=632860")

+-------------------+-----+-----+-----+-----+------+
|               Date| Open| High|  Low|Close|Volume|
+-------------------+-----+-----+-----+-----+------+
|2006-07-03 00:00:00|486.0|490.5|485.0|489.7|632860|
+-------------------+-----+-----+-----+-----+------+

// Number #9
// Returns the first n rows in the Dataset
df.take(5)

res3: Array[org.apache.spark.sql.Row] = Array([2006-01-03 00:00:00.0,490.0,493.8,481.1,492.9,1537660], 
    [2006-01-04 00:00:00.0,488.6,491.0,483.5,483.8,1871020], [2006-01-05 00:00:00.0,484.4,487.8,484.0,486.2,1143160],
    [2006-01-06 00:00:00.0,488.8,489.0,482.0,486.2,1370250], [2006-01-09 00:00:00.0,486.0,487.4,483.0,483.9,1680740])

// Number #10
// Returns the schema of this Dataset
df.schema

res4: org.apache.spark.sql.types.StructType = StructType(StructField(Date,TimestampType,true), 
    StructField(Open,DoubleType,true), StructField(High,DoubleType,true), StructField(Low,DoubleType,true), 
    StructField(Close,DoubleType,true), StructField(Volume,IntegerType,true))

// Number #11
// Returns a new Dataset that contains only the unique rows from this Dataset.
val df2 = df.dropDuplicates()
df2.show()

+-------------------+-----+------+-----+-----+--------+
|               Date| Open|  High|  Low|Close|  Volume|
+-------------------+-----+------+-----+-----+--------+
|2006-04-06 00:00:00|480.6| 481.7|476.6|478.5| 1183450|
|2007-01-03 00:00:00|556.6| 562.8|547.2|552.5| 2282110|
|2007-03-22 00:00:00|519.0| 522.0|516.9|518.4| 2173338|
|2007-04-25 00:00:00|529.9| 539.4|527.8|538.0| 2675362|
|2008-04-04 00:00:00|244.4| 245.0|235.2|240.8| 7337526|
|2006-11-28 00:00:00|496.5| 498.5|494.3|495.6| 1455850|
|2007-11-09 00:00:00|321.0| 344.7|316.0|331.0|15395395|
|2008-06-19 00:00:00|205.0| 207.1|194.1|201.7|15180170|
|2006-08-25 00:00:00|487.3| 488.0|485.0|486.4|  797180|
|2007-04-05 00:00:00|512.1| 517.6|510.5|515.7| 1033954|
|2007-07-02 00:00:00|513.0| 517.5|510.1|516.4| 1806134|
|2006-03-07 00:00:00|458.5| 464.4|458.0|464.0| 1560380|
|2006-05-04 00:00:00|498.5| 498.8|492.6|493.8| 1721280|
|2006-05-10 00:00:00|501.0| 505.7|500.0|503.0| 1591700|
|2008-05-16 00:00:00|238.1| 238.1|230.8|231.2| 6731609|
|2006-09-06 00:00:00|492.1| 492.7|489.1|491.3| 1041370|
|2006-10-25 00:00:00|504.0| 509.3|504.0|508.7| 1416920|
|2007-10-01 00:00:00|458.9| 482.3|458.6|477.2| 5676675|
|2008-01-17 00:00:00|265.2| 275.7|246.0|249.6|23230520|
|2008-09-12 00:00:00|181.9|188.85|177.2|179.6|10991610|
+-------------------+-----+------+-----+-----+--------+
only showing top 20 rows

// Number #12
// Returns a new Dataset with a column dropped
val df2 = df.drop("Date")
df2.show()

+-----+-----+-----+-----+-------+
| Open| High|  Low|Close| Volume|
+-----+-----+-----+-----+-------+
|490.0|493.8|481.1|492.9|1537660|
|488.6|491.0|483.5|483.8|1871020|
|484.4|487.8|484.0|486.2|1143160|
|488.8|489.0|482.0|486.2|1370250|
|486.0|487.4|483.0|483.9|1680740|
|483.0|485.5|480.8|485.4|1365960|
|495.8|495.8|485.8|489.8|1684440|
|491.0|491.0|488.8|490.3|1230060|
|491.0|491.9|487.3|489.2| 940930|
|485.1|487.0|482.7|484.3|1237830|
|484.3|486.7|481.1|483.8|1218910|
|485.6|485.8|477.0|479.4|1696500|
|472.1|474.0|456.3|456.9|4781930|
|460.0|463.8|457.0|460.0|2025500|
|462.9|463.6|459.9|460.1|2083740|
|461.4|463.7|460.1|462.3|1591940|
|465.5|475.5|464.5|470.1|1988600|
|470.1|473.7|466.0|468.7|1412760|
|468.7|469.9|466.6|468.2|1057630|
|468.3|470.5|465.5|465.8|1887280|
+-----+-----+-----+-----+-------+
only showing top 20 rows

// Number #13
// Selects a set of columns. This is a variant of select that can only 
//select existing columns using column names 
val df2 = df.select($"Open", $"High")
df2.show()

+-----+-----+
| Open| High|
+-----+-----+
|490.0|493.8|
|488.6|491.0|
|484.4|487.8|
|488.8|489.0|
|486.0|487.4|
|483.0|485.5|
|495.8|495.8|
|491.0|491.0|
|491.0|491.9|
|485.1|487.0|
|484.3|486.7|
|485.6|485.8|
|472.1|474.0|
|460.0|463.8|
|462.9|463.6|
|461.4|463.7|
|465.5|475.5|
|470.1|473.7|
|468.7|469.9|
|468.3|470.5|
+-----+-----+
only showing top 20 rows

// Number #14
// Returns all column names and their data types as an array.
df.dtypes

res3: Array[(String, String)] = Array((Date,TimestampType), (Open,DoubleType), (High,DoubleType), 
(Low,DoubleType), (Close,DoubleType), (Volume,IntegerType))

// Number #15
// Returns a new Dataset sorted by the given expressions
df.orderBy("Volume").show()

+-------------------+-----+------+-----+-----+------+
|               Date| Open|  High|  Low|Close|Volume|
+-------------------+-----+------+-----+-----+------+
|2006-07-03 00:00:00|486.0| 490.5|485.0|489.7|632860|
|2006-09-01 00:00:00|497.0| 497.1|492.1|493.7|744150|
|2006-09-05 00:00:00|493.1| 496.8|491.2|494.2|775640|
|2006-08-11 00:00:00|479.2| 479.2|472.2|476.4|782330|
|2006-04-12 00:00:00|475.0| 478.3|474.8|476.0|787030|
|2006-08-25 00:00:00|487.3| 488.0|485.0|486.4|797180|
|2006-07-07 00:00:00|492.7| 495.9|490.1|490.8|807950|
|2006-11-13 00:00:00|505.0| 509.5|505.0|506.9|809470|
|2006-07-11 00:00:00|493.4| 496.8|488.6|496.0|816880|
|2006-08-21 00:00:00|485.5| 486.3|483.8|484.9|820040|
|2006-07-10 00:00:00|493.3| 496.4|491.0|493.4|838870|
|2006-03-24 00:00:00|477.5| 480.0|475.5|478.1|869610|
|2006-12-26 00:00:00|546.8| 551.9|545.2|551.2|880650|
|2006-09-19 00:00:00|495.9| 497.1|493.0|497.0|918460|
|2006-08-07 00:00:00|483.4| 485.6|481.1|482.3|918750|
|2006-09-08 00:00:00|485.1| 487.9|484.8|487.2|920000|
|2006-05-16 00:00:00|496.4| 497.0|490.6|495.4|939000|
|2006-01-13 00:00:00|491.0| 491.9|487.3|489.2|940930|
|2006-07-06 00:00:00|490.7|495.42|490.7|492.7|942690|
|2006-12-22 00:00:00|549.5| 551.0|544.6|545.5|964770|
+-------------------+-----+------+-----+-----+------+
only showing top 20 rows