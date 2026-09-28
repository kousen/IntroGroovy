package json

import groovy.json.JsonSlurper

// Always pass a category: the unfiltered endpoint can return explicit jokes
String base = 'https://api.chucknorris.io/jokes/random?'
String qs =
        [category: 'dev']
                .collect { k,v -> "$k=$v" }
                .join('&')
String jsonTxt = "$base$qs".toURL().text
def json = new JsonSlurper().parseText(jsonTxt)
assert json.value
println json.value
