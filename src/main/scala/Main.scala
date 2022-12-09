
import sttp.client3._

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}
object Main {
  def main(args: Array[String]): Unit = {
    import scala.util.control.Breaks.{break, breakable}

    //val input = Utils.readFromFile("Input/Day8/Input_day5.txt")
    val input = Utils.readFromFile("Input/Day8/Example_Day8.txt")

    val parsedInput:Array[Array[Int]] = input.map{line => line.map{ch=>ch.asDigit}.toArray }

    val transposedInput: Array[Array[Int]] = parsedInput.transpose

    // total trees
    var totalTrees = parsedInput.length * parsedInput.head.length

    //visible from left
    def visibleFromLeft(in: Array[Int], currentPos:(Int,Int)):Boolean = {
      val max = in.max
      (max == parsedInput(currentPos._1)(currentPos._2)) && (in.count(_ == max) == 1)
    }

    //visible from the top
    def visibleFromTop(in: Array[Int], currentPos:(Int,Int)):Boolean = {
      val max = in.max
      (max == transposedInput(currentPos._1)(currentPos._2)) && (in.count(_ == max) == 1)
    }

    //visible from the right
    def visibleFromRight(in: Array[Int], currentPos:(Int,Int)):Boolean = {
      val max = in.max
      max == parsedInput(currentPos._1)(currentPos._2) && (in.count(_ == max) == 1)
    }

    //visible from the bottom
    def visibleFromDown(in: Array[Int], currentPos:(Int,Int)):Boolean = {
      val max = in.max
      max == transposedInput(currentPos._1)(currentPos._2) && (in.count(_ == max) == 1)
    }


    for(i<- 1 until parsedInput.length){
      for(j<-1 until parsedInput.head.length-1){

        breakable{
          if(visibleFromLeft(parsedInput(i).take(j+1),(i,j))){
            break
            // visibleFromTop
          }else if (visibleFromTop(transposedInput(j).take(i+1),(j,i))){
            break
          }else if(visibleFromRight(parsedInput(i).drop(j),(i,j))){
            break
            //visibleFromDown
          }else if (visibleFromDown(transposedInput(j).drop(i),(j,i))){

          }else{
            //not visible
            totalTrees-=1
          }
        }

      }
    }

    totalTrees
    print(totalTrees)

    //**********Part two******************


    //visible from left
    def distanceFromLeft (in:Array[Int]):Int = {
      val arr = in.reverse.drop(1)
      val head = in.reverse.head
//      arr.count(height => height <= head  )
      val blockTressPos = arr.indexWhere(height => height >= in.head)
      if(blockTressPos == 0) {

        //first tree is the same height
        if(arr(0) == in.head) {
          1}
        else {
          //          none of the trees are taller
          arr.length
        }
      }
      else blockTressPos + 1
    }

    //def distanceFromTop:Int () = {}

    def distanceFromRight(in:Array[Int]):Int = {
      val arr = in.drop(1)

       + 1
      val blockTressPos = arr.indexWhere(height => height >= in.head)
      if(blockTressPos == 0) {

        //first tree is the same height
        if(arr(0) == in.head) {
          1}
        else {
//          none of the trees are taller
          arr.length
        }
        }
      else blockTressPos + 1
    }

    def distanceFromDown:Int = ???

    def totalDistance:Int = ???


val score:ListBuffer[Int] = ListBuffer.empty
    for(i<- 1 until parsedInput.length){
      for(j<-1 until parsedInput.head.length-1){

      val l = distanceFromLeft(parsedInput(i).take(j+1))
       val t =   distanceFromLeft(transposedInput(j).take(i+1))
        val r =  distanceFromRight(parsedInput(i).drop(j))
         val b=  distanceFromRight(transposedInput(j).drop(i))
        val tot = l*t*r*b

          score.addOne(tot)
      }
    }
    println(score)




    //    val p = Array(Array(3,0,3,7,3), Array(2,5,5,1,2),Array(6,5,3,3,2), Array(3,3,5,4,9),Array(3,5,3,9,0))
//
//   val o= p.transpose
//    print("")


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
