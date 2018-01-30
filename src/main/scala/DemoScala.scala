import java.util.Random

object DemoScala {
  def main(args: Array[String]): Unit = {
    val myrandom = new Random().nextInt(100)
    println(myrandom.toString)
  }

}
