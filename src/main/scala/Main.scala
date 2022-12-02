
import sttp.client3._
//object Main {
////  def main(args: Array[String]): Unit = {
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
////  }
//
//
//}
