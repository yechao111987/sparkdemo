import yechao.ScalaDemo

object MainF {
  def main(args: Array[String]): Unit = {
    val sd: ScalaDemo = new ScalaDemo
    val xx = sd.collect("E:\\code\\MyCode\\yechao.txt")
    val x1 = xx.collect()
    println(x1)
  }

}
