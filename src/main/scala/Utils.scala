import scala.io.Source

object Utils {

  def readFromFile(fileName: String): Array[String] = {
    val bufferedSource = Source.fromResource(fileName)
    val input = bufferedSource.getLines().toArray
    bufferedSource.close()
    input
  }

  def readFromFileStringIterator(fileName: String):Iterator[String] = {
    val bufferedSource = Source.fromResource(fileName)
    val input = bufferedSource.getLines()
    bufferedSource.close()
    input
  }
}
