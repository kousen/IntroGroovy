package geocode

import groovy.transform.ToString;

@ToString(includeNames=true)
class Location {
    String street
    String city
    String state
    double latitude
    double longitude
}
