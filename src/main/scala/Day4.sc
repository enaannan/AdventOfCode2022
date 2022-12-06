//todo: convert input to Array[Array[Array[(Int, Int)]]] ie Array(Array((2,4),(6,8)), Array((2,3),(4,5)))
val input: Array[Array[String]] = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
  .split("\n")
  . map(_.split(","))


input.flatten
println(input.head.last)



// pivot is the one with larger value of 2
//last of small == <= last of big && first of pivot == <=first of other

//6-9, 4-8