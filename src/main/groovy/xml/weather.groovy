/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package xml

import groovy.xml.XmlSlurper

String key = System.getenv('OPENWEATHERMAP_API_KEY')
String url = 'https://api.openweathermap.org/data/2.5/weather?' +
        "q=Hartford,CT,US&mode=xml&units=imperial&appid=$key"
def root = new XmlSlurper().parse(url)
println "${root.city.@name}: ${root.temperature.@value} F, ${root.weather.@value}"
