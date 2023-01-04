import scala.collection.mutable
import scala.io.Source

val bufferedSource = Source.fromResource("Input/Day5/Input_day5.txt")
val input = bufferedSource.getLines().toArray
bufferedSource.close()

//example input
//    val initialCrateArrangement = Map[Int,mutable.Stack[Char]](
//      1->mutable.Stack('N', 'Z'),
//      2-> mutable.Stack('D','C','M'),
//      3->mutable.Stack('P')
//    )


//actual input
val initialCrateArrangement = mutable.SortedMap[Int,mutable.Stack[Char]](
  1->mutable.Stack('P','V','Z','W','D','T'),
  2-> mutable.Stack('D','J','F','V','W','S','L'),
  3->mutable.Stack('H','B','T','V','S','L','M','Z'),
  4->mutable.Stack('J', 'S','R'),
  5-> mutable.Stack('W','L','M','F','G','B','Z','C'),
  6->mutable.Stack('B','G','R','Z','H','V','W','Q'),
  7->mutable.Stack('N','D','B','C','P','J','V'),
  8-> mutable.Stack('Q','B','T','P'),
  9->mutable.Stack('C','R','Z','G','H')
)



case class Move( quantity:Int, from:Int, to:Int)

val moves = input.map {
  case s"move $quantity from $from to $to" => Move(quantity.toInt, from.toInt, to.toInt)
}

def popNTimes( number:Int, stk: mutable.Stack[Char]):List[Char]={
  val popped = List.newBuilder[Char]

  for(i <- 0 until number) {
    popped.addOne(stk.pop())
  }
  popped.result()
}


moves.map{ move =>
  val stk =  initialCrateArrangement(move.from)
  val cratesToMove = popNTimes(move.quantity,stk)
  initialCrateArrangement(move.to).pushAll(cratesToMove)
}
  initialCrateArrangement.map{case (dock:Int, crates: mutable.Stack[Char]) => crates.top  }.toList

//Part Two
moves.map{ move =>
  val stk =  initialCrateArrangement(move.from)
  val cratesToMove = popNTimes(move.quantity,stk)
  initialCrateArrangement(move.to).pushAll(cratesToMove.reverse)
}
initialCrateArrangement.map{case (dock:Int, crates: mutable.Stack[Char]) => crates.top  }.toList
