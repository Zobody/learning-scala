

def step(number : Int) : Int = {

  val numMod3 = number % 3
  val addValue = if (numMod3 == 1) -1 else if (numMod3 == 2) 1 else 0

  val returnValue = (number + addValue) / 3

  println(number + " " + addValue)

  if (returnValue != 1) step(returnValue) else println(returnValue)

  returnValue
}

step(args(0).toInt)