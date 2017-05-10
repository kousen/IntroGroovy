package json

import com.google.gson.Gson

String base = 'http://api.icndb.com/jokes/random?'
def qs = [limitTo: ['nerdy'], firstName: 'Guillaume',
          lastName: 'Laforge'].collect { k,v -> "$k=$v" }.join('&')
String jsonTxt = "$base$qs".toURL().text

Gson gson = new Gson()
Model model = gson.fromJson(jsonTxt, Model)
println model
println model.value.joke