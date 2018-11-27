class Point(val x: Int, val y: Int)

trait Rectangular {
	def topLeft: Point
	def bottomRight: Point

	def left = topLeft.x
	def right = bottomRight.x
	def width = right - left
	// etc
}

abstract class Component extends Rectangular {
	// somethign about Component here, probably
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
	// again, whatever Rectangles need.
}