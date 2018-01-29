import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "E:/software/hadoop-2.8.0")
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val input = sc.textFile("/E:/software/spark.txt")
    val lines = input.flatMap(line => line.split(" "))
    val count = lines.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    val output = count.saveAsTextFile("/E:/software/spark_resulttxt5")
  }
}
