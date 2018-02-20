
val funValue = nestedFun _
def nestedFun(x: Int): Unit = {
	if (x != 0) {
		println(x)
		funValue(x - 1)
	}
}

nestedFun(args(0).toInt)