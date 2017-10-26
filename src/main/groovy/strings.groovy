String s = 'this is a sentence'
println s.length()
println s.size()
assert s.length() == s.size()

println s[0..3] // getAt(Range)
println s[3..0]
println s[-1..0]
assert s[-1..0] == s.reverse()

println s - 'is' - 'is'

println 'abc' * 3
// println 3 * 'abc'

Date now = new Date()
Date then = now + 3
(now..then).each {
    println it.format('EEEE, MMMM dd, yyyy')
}

List strings = 'this is a list of strings'.split()
println strings
println strings.size()
println strings*.size()
println strings.collect { it.size() }
println strings.collect { String str -> str.size() }