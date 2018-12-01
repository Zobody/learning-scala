import org.scalatest.Suite
import Element.elem

class ElementSuite extends Suite {
	def testUniformElement() { // Test methods start with "test"
		val ele = elem('x', 2, 3)
		assert(ele.width == 2)
	}
}