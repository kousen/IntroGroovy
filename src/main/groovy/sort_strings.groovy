import java.util.stream.Collectors

List strings = 'this is a list of strings'.split()
println strings

// Java has Collections.sort(list) (natural order)
Collections.sort(strings)
println strings

// Java 8 has sorted() on Stream
List sorted = strings.stream()
    .sorted()
    .collect(Collectors.toList())
println sorted

sorted = strings.sort(false)
println sorted

// Two-param Groovy length sort
sorted = strings.sort(false) { s1, s2 -> s1.size() - s2.size() }
println sorted
assert sorted*.size() == [1, 2, 2, 4, 4, 7]

// One-param Groovy reverse length sort
sorted = strings.sort(false) { -it.size() }
println sorted
assert sorted*.size() == [7, 4, 4, 2, 2, 1]

// Java 8
sorted = strings.stream()
    .sorted(Comparator.comparingInt({ it.size() })
        .thenComparing(Comparator.naturalOrder()))
    .collect(Collectors.toList())
println sorted

// Groovy sort by length, then equal lengths alphabetically
sorted = strings.sort { s1, s2 ->
    s1.size() <=> s2.size() ?: s2 <=> s1
}
println sorted