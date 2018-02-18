// Listing 7.16 : Looping without break or continue

var i = 0
var foundIt = false

while (i < args.length && !foundIt) {
	if (!args(i).startsWith("-")) {
		if (args(i).endsWith(".scala"))
			foundIt = true
	}
	i = i + 1
}

println(args(i-1))

// This is the ugliest code written yet, since I started learning scala