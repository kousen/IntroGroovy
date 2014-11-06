package flikr

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
              tags: 'cat',
              nojsoncallback: 1,
              media: 'photos',
              per_page: 6]

// Build URL and download JSON data
def qs = params.collect { it }.join('&')
String jsonTxt = "$endPoint$qs".toURL().text

// write formatted JSON data to file
File f = new File('cats.json')
if (f) f.delete()
f << jsonTxt
println JsonOutput.prettyPrint(jsonTxt)

// parse JSON data and build URL for pictures
def json = new JsonSlurper().parseText(jsonTxt)
def urls = json.photos.photo.collect { p ->
    "http://farm${p.farm}.staticflickr.com/${p.server}/${p.id}_${p.secret}.jpg"
}

// build UI using Swing
new SwingBuilder().edt {
    frame(title:'Cat pictures', visible: true, pack: true,
        defaultCloseOperation: WC.EXIT_ON_CLOSE, 
        layout:new GridLayout(0, 2)) {
        urls[0..5].each { String url ->
            label(icon:new ImageIcon(url.toURL()))
        }
    }
}
