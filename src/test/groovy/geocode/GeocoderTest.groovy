package geocode

import static org.junit.Assert.*
import org.junit.Test;

class GeocoderTest {
    Geocoder geo = new Geocoder()
    
    @Test
    void testMountainViewCA() {
        Location google = new Location(street:'1600 Ampitheatre Parkway',
            city:'Mountain View', state:'CA')
        geo.fillInLatLng(google)
        assertEquals(37.4, google.latitude, 0.1)
        assertEquals(-122.1, google.longitude, 0.1)
    }
}