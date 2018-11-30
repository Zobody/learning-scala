
package p

class Super {
	protected def prot() { println("prot") }
	private def priv() { println("priv") }

	class SuperInner {
		prot()
		priv()
	}

}

class Sub extends Super {
	prot()
	// priv() // error: not found: value priv

	class SubInner {
		prot()
		// priv() // error: not found: value priv
	}

}

class Other {
	// (new Super).prot() // error: prot is not accesible
	// (new Super).priv() // method priv in class Super cannot be accessed in p.Super
}