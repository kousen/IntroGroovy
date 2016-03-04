package json

import groovy.json.JsonSlurper
import groovy.json.JsonException

def url = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'

try {
    def json = new JsonSlurper().parseText(url.toURL().text)
    def joke = json?.value?.joke
    assert joke
    println joke
} catch (JsonException e) {
    e.printStackTrace()
}
