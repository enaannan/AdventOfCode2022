
import sttp.client3._

import scala.io.Source
object Main {
  def main(args: Array[String]): Unit = {

    val bufferedSource = Source.fromResource("Input/Day4/Input_day4.txt")
    val input = bufferedSource.getLines()

    val parsedInput: Seq[Array[(Int, Int)]] = {
      for(line <- input) yield {
        val Array(x,y,a,b) = line.split("[,-]").map(_.toInt)

        Array((x,y),(a,b))
      }
    }.toList

    bufferedSource.close()

    def subsume(elfA: (Int,Int),elfB: (Int,Int)):Boolean = {
      (elfA._1 <= elfB._1) && (elfA._2 >= elfB._2)
      //  ||
      //    (elfA._1 >= elfB._1) && (elfA._2 >= elfB._2)
    }

    parsedInput.count{elfPair:Array[(Int,Int)] =>
      subsume(elfPair.head,elfPair.last) || subsume(elfPair.last,elfPair.head )
    }


//   val p = Utils.readFromFile("Input/nii")
//    println(p)
//    input.map(a=> a.map(_.split("-")))
//
//    val input = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
//      .split("[,-]")
//
//    println(input.toList)
//
//print("df")
//    input.flatten
//    println(input.head.last)


////    import sttp.client3._
////
////    val SESSION = sys.env.get("session")
////    if (SESSION.isEmpty){
////      println("Configure session cookie")
////    }
////
////    // the `query` parameter is automatically url-encoded
////    // `sort` is removed, as the value is not defined
////    val request = basicRequest
////      .cookie("session"-> SESSION.get)
////      .get(uri"https://adventofcode.com/2021/day/1/input")
////
////    val backend = HttpClientSyncBackend()
////    val response = request.send(backend)
////
////    // response.body: by default read into an Either[String, String] to indicate failure or success
////    println(response.body)
////    println("Hello world")
////
////    //todo: write response body into a file
  }
//
//
}
