package flickr

import groovy.json.*
import groovy.swing.SwingBuilder

import java.awt.GridLayout
import javax.swing.ImageIcon
import javax.swing.WindowConstants as WC

String key = new File('flickr_key.txt').text
String endPoint = 'https://api.flickr.com/services/rest?'
def params = [method: 'flickr.photos.search',
              api_key: key,
              format: 'json',
              tags: 'kitties',
              nojsoncallback: 1,
              media: 'photos',
              per_page: 6]

// Build URL and download JSON data
def qs = params.collect { it }.join('&')
// def qs = params.collect { k,v -> "$k=$v" }.join('&')
// def qs = params*.toString().join('&')
println "$endPoint$qs"
String jsonTxt = "$endPoint$qs".toURL().text

// write formatted JSON data to file
File f = new File('cats.json')
if (f) f.delete()
f << JsonOutput.prettyPrint(jsonTxt)
println JsonOutput.prettyPrint(jsonTxt)

// parse JSON data and build URL for pictures
def json = new JsonSlurper().parseText(jsonTxt)
def photos = json.photos.photo

// build UI using Swing
new SwingBuilder().edt {
    frame(title:'Cat pictures', visible: true, pack: true,
        defaultCloseOperation: WC.EXIT_ON_CLOSE, 
        layout:new GridLayout(0, 2, 2, 2)) {
        photos.each { p ->
            String url = "http://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg"
            String title = p.title
            label(icon: new ImageIcon(url.toURL()), toolTipText: title)
        }
    }
}
