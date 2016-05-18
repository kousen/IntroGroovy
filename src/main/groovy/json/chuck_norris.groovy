package json

import groovy.json.JsonSlurper

def url = 'http://api.icndb.com/jokes/random?limitTo=[nerdy]'

def json = new JsonSlurper().parseText(url.toURL().text)
println json?.value?.joke
