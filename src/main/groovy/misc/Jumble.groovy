package misc

import groovy.transform.CompileStatic

@CompileStatic
class Jumble1 {
    private List<String> wordList =
            new File('/usr/share/dict/words').readLines()
                    .findAll { it.size() == 5 || it.size() == 6 }

    String solve(String clue) {
        List<String> letters = clue.split('').toList()
        letters.permutations()
                .collect { it.join('') }
                .find { wordList.contains(it) }
    }
}

@CompileStatic
class Jumble2 {
    private Map<String, List<String>> wordMap =
            new File('/usr/share/dict/words').readLines()
                .findAll {it.size() == 5 || it.size() == 6 }
                .groupBy { it.toList().sort().join('') }

    String solve(String clue) {
        def key = clue.toList().sort().join('')
        wordMap[key].head()
    }
}



