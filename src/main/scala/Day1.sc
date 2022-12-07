//val input:List[String] = Utils.readFromFile("Input/Day1/Example_Day1.txt").toList
val input= Utils.readFromFile("Input/Day1/Input_day1.txt")
def findSum(in:List[String]) ={
 in.foldLeft(List[Int](0))((a,b)=> b match {
   case currentNum if currentNum.isEmpty => a.+:(0)
   case _ =>
     val i = a.head
     a.drop(1).+:(i+ b.toInt)
 })
}

val result: Seq[Int] = findSum(input)sorted Ordering.Int.reverse
val elfWithMostCal = result.max
println(elfWithMostCal)

//*************************** Part Two ***********************//
val maxThreeElf = result.take(3).sum
println(maxThreeElf)



