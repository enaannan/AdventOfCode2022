import scala.io.Source

object Utils {

  def readFromFile(fileName: String): Array[String] = {
    val bufferedSource = Source.fromFile(fileName)
    val input = bufferedSource.getLines().toArray
    bufferedSource.close()
    input
  }
}
