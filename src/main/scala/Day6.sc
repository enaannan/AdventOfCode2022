val input:String = Utils.readFromFile("Input/Day6/Example_Day6.txt").mkString("Array(", ", ", ")")

def findMarker(input:String, quantity:Int):Int={
  val res = input.sliding(quantity).find{str => str.distinct.length == str.length}
  input.indexOf(res.get) + quantity
}

findMarker(input,4)


//*************Part Two******************
findMarker(input,14)