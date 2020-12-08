// Practice #3

// BASIC STATISTICS

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
//package org.apache.spark.examples.ml


import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
import org.apache.spark.ml.stat.Summarizer
import org.apache.spark.sql.SparkSession

object ChiSquareTestExample {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("ChiSquareTestExample")
      .getOrCreate()
    import spark.implicits._

    // Declare a value of name data to which a sequence of dense vectors is assigned    val data = Seq(
      (0.0, Vectors.dense(0.5, 10.0)),
      (0.0, Vectors.dense(1.5, 20.0)),
      (1.0, Vectors.dense(1.5, 30.0)),
      (0.0, Vectors.dense(3.5, 30.0)),
      (0.0, Vectors.dense(3.5, 40.0)),
      (1.0, Vectors.dense(3.5, 40.0))
    )

    // A new dataframe is created to which the data value is assigned in the label and features columns
       val df = data.toDF("label", "features")
	// A chi value is created to which ChiSquare is applied through the libraries, to the data frame in its features and label columns
    val chi = ChiSquareTest.test(df, "features", "label").head 
    println(s"pValues = ${chi.getAs[Vector](0)}")
    println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
    println(s"statistics ${chi.getAs[Vector](2)}")
    // 

	}		
}

object CorrelationExample {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("CorrelationExample")
      .getOrCreate()
    import spark.implicits._

    // A value called data is created to which a sequence of vectors is assigned as value
    val data = Seq(
      Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))), // (0,3,1,-2)
      Vectors.dense(4.0, 5.0, 0.0, 3.0),
      Vectors.dense(6.0, 7.0, 0.0, 8.0),
      Vectors.sparse(4, Seq((0, 9.0), (3, 1.0))) // (0,3,9,1)
    )

    // A dataframe is created which is assigned the value of a Tuple called Tuple1,
    // the data frame contains a column called features
    val df = data.map(Tuple1.apply).toDF("features")
    
    // A Row type value called coefficient1 of a matrix is assigned the value of the pearson correlation applied to the dataframe
    // 
    val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
    // It is printed
    println(s"Pearson correlation matrix:\n $coeff1") 


    // A Row type value called coefficient2 of a matrix is assigned the value of the spearman correlation applied to the dataframe
    //Applied to the column features
    val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
    println(s"Spearman correlation matrix:\n $coeff2") //Se imprime
    }		
}


object SummarizerExample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("SummarizerExample")
      .getOrCreate()

    import spark.implicits._
    //Import Summarizer 
    import Summarizer._

    // Data value will contain two vectors
    val data = Seq(
      (Vectors.dense(2.0, 3.0, 5.0), 1.0),
      (Vectors.dense(4.0, 6.0, 7.0), 2.0)
    )
    // Df value to refer to "Feactures" and "weight"
    val df = data.toDF("features", "weight")
    // Two values for the mean and variance;
    // Select the metrics (Mean, Variance)
    val (meanVal, varianceVal) = df.select(metrics("mean", "variance")
    // Summary method that we will apply to Feactures and Weight and give it an alias
      .summary($"features", $"weight").as("summary"))
    // We select the Summary with its respective metric
      .select("summary.mean", "summary.variance")
    // We give you the way we want to print
      .as[(Vector, Vector)].first()
    // We send to printing to show the values of the Mean and Variance
    println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")
    // Second Value without using the Summary method
    val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
      .as[(Vector, Vector)].first()

    println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
    // $example off$

    spark.stop()
  }
}


// :load Practice3.scala
// SummarizerExample.main(Array())
