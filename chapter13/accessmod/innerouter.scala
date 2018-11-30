
class Outer {

	class Inner {

		private def f() {println("f")} // defined in Inner, available in Inner and in everything that's inside Inner

		class InnerMost {

			f() // OK

		}

		f() // OK

	}

	// (new Inner).f() // NOT OK
}