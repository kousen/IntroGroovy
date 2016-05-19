package ast.sortable

import groovy.transform.Canonical
import groovy.transform.Sortable

@Sortable(includes = ['score', 'last', 'first'])
class Golfer {
    int score
    String first
    String last

    String toString() { "$first $last ($score)" }
}
