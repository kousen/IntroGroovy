package json

import groovy.json.JsonSlurper

String base = 'http://api.icndb.com/jokes/random?'
String qs = [limitTo: '[nerdy]', firstName: 'Guillaume',
        lastName: 'Laforge'].collect { k,v -> "$k=$v" }
        .join('&')
URL url = "$base$qs".toURL()
def json = new JsonSlurper().parseText(
        url.getText(requestProperties: ['User-Agent':'']))
println json?.value?.joke
