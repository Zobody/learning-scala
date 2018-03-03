
val column1 = elem("hello") above elem("***")
val column2 = elem("***") above elem("world")

val result = column1 beside column2

println(
	result
)