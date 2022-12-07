import scala.io.Source

//val bufferedSource = Source.fromResource("Input/Day4/Example_Day4.txt")
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
  ((elfA._1 <= elfB._1) && (elfA._2 >= elfB._2)) || ((elfA._1 >= elfB._1) && (elfA._2 <= elfB._2))
}

parsedInput.count{elfPair:Array[(Int,Int)] =>
subsume(elfPair.head,elfPair.last)
}

//*************part two *************

def overlap(elfA: (Int,Int),elfB: (Int,Int))={
  ((elfA._1 <= elfB._1) && (elfA._2>= elfB._1) || (elfA._1 <= elfB._2) && (elfA._2>= elfB._2)) ||
    ((elfA._1 >= elfB._1) && (elfA._1<= elfB._2) || (elfA._2 >= elfB._1) && (elfA._2<= elfB._2))
}
parsedInput.count{elfPair:Array[(Int,Int)] =>
  overlap(elfPair.head,elfPair.last)
}