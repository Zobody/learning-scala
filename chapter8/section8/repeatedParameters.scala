
def echo(args: String*) = // Notice the asterisk
	for(arg <- args) println(arg)

echo()
echo("one")
echo("hello", "world!")

val arr = Array("What's", "up", "doc?")

/*
echo(arr) // compiler error, type mismatch
*/

echo(arr: _*) // will pass each element of arr as its own argument, instead of passing it as a single arugment