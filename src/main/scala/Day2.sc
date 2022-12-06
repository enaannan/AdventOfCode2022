val input:Array[String] = Utils.readFromFile("Input/Day2/Example_Day2")

val playerA = Map("A"->0,"B"->1,"C"->2)
val playerB = Map("X"->0,"Y"->1,"Z"->2)

val scoreB = Map("X"->1,"Y"->2,"Z"->3)

val expectedOutCome = Map("X"->0,"Y"->3,"Z"->6)

val winningBoard: Array[Array[Int]] =  Array(
  Array(3, 6, 0),
  Array(0, 3, 6),
  Array(6, 0, 3)
  )

    def solve(pA:String, pB:String):Int={
      val outcome = winningBoard(playerA(pA))(playerB(pB))
      val score = scoreB(pB)
      outcome + score
    }

val res: Int = input.map { round =>
 val play: Array[String] = round.split(" ")
  solve(play.head,play.last)
} .sum
print(res)

//************** part two *****************************************

def solvePart2(pA:String, pB:String):Int ={
  val handToPlayIndex: Int = winningBoard(playerA(pA)).indexOf(expectedOutCome(pB))
  println(s"handToPlayIndex: $handToPlayIndex")
  val handToPlay: Option[String] = playerB.find(_._2 == handToPlayIndex).map(_._1)
  println(s"handToPlay: $handToPlay")
  val outcome = winningBoard(playerA(pA))(handToPlayIndex )
  println(s"outcome: $outcome")
  val handScore =  scoreB(handToPlay.get)
  println(s"handScore: $handScore")
  outcome + handScore
}

//println(solvePart2("B","X"))
val res2: Int = input.map { round =>
  val play: Array[String] = round.split(" ")
  val k = solvePart2(play.head,play.last)
  println(k)
  k
} .sum
print(res2)

