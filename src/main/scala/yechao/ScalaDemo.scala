package yechao

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

class ScalaDemo {
  def collect(path: String): RDD[String] = {
    System.setProperty("hadoop.home.dir", "E:/software/hadoop-2.8.0")
    val conf = new SparkConf().setMaster("local").setAppName("demo")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val xx: RDD[String] = sc.textFile(path)
    xx
  }

  //  def analyseText(rDD: RDD[String]): RDD = {
  //
  //  }

}
