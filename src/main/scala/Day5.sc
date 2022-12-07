import scala.collection.immutable.Queue
import scala.io.Source

val bufferedSource = Source.fromResource("Input/Day5/Example_Day5.txt")
val input = bufferedSource.getLines().toArray
bufferedSource.close()

val initialCrateArrangement = Map[Int,List[Char]](
  1->List('N','Z'),
  2-> List('D','M', 'C'),
  3->List('P')
)

val movement: Array[List[Int]] = input.map{ move=>
  List(move.charAt(5).asDigit,move.charAt(12).asDigit,move.charAt(17).asDigit)
}

movement.map{ move =>
  val (removedBoxes,remainingBoxes) = initialCrateArrangement(move(1)).splitAt(move.head)
initialCrateArrangement(move(2)).appendedAll(removedBoxes)
  initialCrateArrangement(move(1)).appendedAll(remainingBoxes).drop(move.head)
}
//List(1,23,4).splitAt(2)
//val p = Queue(1,2,3,4,5).splitAt(2)