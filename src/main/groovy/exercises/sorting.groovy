package exercises

import java.util.function.Function
import java.util.stream.Collectors

List strings = 'this is a list of strings'.split()

def sorted = strings.sort(false)

println strings
println "Alphabetical, asc: $sorted"

List others = 'this is a list of strings'.split()
Collections.sort(others, new Comparator<String>() {
    int compare(String s1, String s2) {
        return s1.length() - s2.length()
    }
})
println "$others (Java 7 length sort)"

// Java 7 sort
Collections.sort(others)
println "$others (Java natural sort)"

// Java 8+ length sort
sorted = strings.stream()
        .sorted(Comparator.comparing { String s -> s.size() })
        .collect(Collectors.toList())
println "$sorted (Java)"

// Groovy 2-arg closure
sorted = strings.sort(false) { s1, s2 -> s1.size() <=> s2.size() }
println "$sorted (Groovy, 2-arg closure)"

// Groovy 1-arg closure
sorted = strings.sort(false) { -it.size() }
println "$sorted (Groovy reverse sort, 1-arg closure)"

sorted = strings.sort(false) { s1, s2 ->
    s1.size() <=> s2.size() ?: s2 <=> s1
}
println "$sorted (Groovy, by length then reverse alpha)"

Function<String,Integer> sizeFunction = { s -> s.size() }
Comparator<String> reverseNatural = Comparator.reverseOrder()

sorted = strings.stream()
    .sorted(Comparator.comparing(sizeFunction)
            .thenComparing(reverseNatural) )
    .collect(Collectors.toList())
println "$sorted (Java stream sort with thenComparing)"