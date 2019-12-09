package json

import groovy.json.JsonSlurper

String base = 'http://api.icndb.com/jokes/random?'
String qs = [limitTo: '[nerdy]', firstName: 'Guillaume',
        lastName: 'Laforge'].collect { k,v -> "$k=$v" }
        .join('&')
String jsonTxt = "$base$qs".toURL().text
def json = new JsonSlurper().parseText(jsonTxt)
println json?.value?.joke
