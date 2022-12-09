import scala.collection.mutable.ListBuffer
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

