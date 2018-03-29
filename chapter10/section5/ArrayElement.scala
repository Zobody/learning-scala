// Listing 10.4 : Overriding a parameterless method with a field.

class ArrayElement(conts: Array[String]) extends Element {
	val contents: Array[String] = conts
}