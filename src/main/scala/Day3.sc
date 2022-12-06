val input:Array[String] = Utils.readFromFile("Input/Day3/Example_Day3.txt")


def findDups(in:Array[String]): Seq[Char] ={
  in.map{ rucksack:String =>
    val(compartmentA,compartmentB) = rucksack.splitAt(rucksack.length/2)
    compartmentA.distinct.intersect(compartmentB.distinct)
  }. map(_.charAt(0)).toSeq
}

def findPriority(items:Seq[Char])={
  val (upper,lower) = items.partition(_.isUpper)
  val upperSum = upper.map(_.toInt - 38
    ).sum
  val lowerSum = lower.map(_.toInt - 96).sum
  upperSum + lowerSum
}
val sumOfItemPriority = findDups(input)

print(findPriority(findDups(input)))

//****************************part two******************************
def findDupsInGroup(in:Array[String]): Int ={
  val groups: Seq[Array[String]] = in.sliding(3,3).toList

  val chars: Seq[Char] = ('a' to 'z') ++ ('A' to 'Z')

  groups.foldLeft(chars)((a,b)=> a.intersect(b))
  val intersects = groups.map{ group: Array[String] =>
    group.foldLeft(chars)((a,b)=> a.intersect(b))
  }
  intersects.map(findPriority).sum
}
println(findDupsInGroup(input))
