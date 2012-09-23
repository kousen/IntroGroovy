package geocode

class Geocoder {
    public static final String BASE = 'http://maps.googleapis.com/maps/api/geocode/xml?'

    def fillInLatLng(Location loc) {
        String encoded = [loc.street, loc.city, loc.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',+')
        String qs = [address:encoded, sensor:false].collect { it }.join('&')
        def root = new XmlSlurper().parse(BASE + qs)
        loc.latitude = root.result[0].geometry.location.lat.toDouble()
        loc.longitude = root.result[0].geometry.location.lng.toDouble()
    }
}
