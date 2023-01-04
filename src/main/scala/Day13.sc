//val input = Utils.readFromFile("Input/Day8/Input_day5.txt")
val input = Utils.readFromFileStringIterator("Input/Day13/Example_Day13.txt")


val p:Array[String] = for{
   line <- input
  if line !=""
} yield Array(line)

println(p)