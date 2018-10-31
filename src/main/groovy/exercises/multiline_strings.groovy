package exercises

String str = '''\
This is a multiline string
with four lines in it 
and I need to find the
number of vowels on each line
'''

def vowelCoounts = str.toLowerCase().readLines()
    .collect { line -> line.findAll(/[aeiou]/).size() }

vowelCoounts.eachWithIndex { val, idx ->
    println "On line ${idx + 1} there are $val vowels"
}