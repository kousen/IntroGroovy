package exercises

String s = 'this is a sentence'
assert s.length() == s.size()

println s[0..3]
println s[3..0]
assert s[-1..0] == s.reverse()