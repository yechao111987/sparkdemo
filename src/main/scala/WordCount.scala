import java.text.SimpleDateFormat
import java.util.{Date, Random}

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "E:/software/hadoop-2.8.0")
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val input = sc.textFile("/E:/software/spark.txt")
    val inputStr = input.collect()
    val lines = input.flatMap(line => line.split(" "))
    val democount = lines.map(word => (word, 1));
    val dc = democount.collect()
    val aa = democount.reduceByKey {
      case (x, y) => x + y
    }
    val a2 = democount.reduceByKey((x, y) => x + y).collect()
    val ab = aa.collect()
    val count = lines.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    val cc = count.collect()
    println(cc)
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println(date)
    val random = new Random().nextInt(100)
    val output = count.saveAsTextFile("E:/software/spark_result1" + random.toString)

    //    val demo1 = sc.pa
  }
}
