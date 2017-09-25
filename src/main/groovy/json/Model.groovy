package json

import groovy.transform.Canonical

@Canonical
class Model {
    String type
    Value value
}

@Canonical
class Value {
    int id
    String joke
    String[] categories
}
