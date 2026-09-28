Source code for the IntroGroovy workshop, based on the book
[Making Java Groovy](https://www.manning.com/books/making-java-groovy) by Ken Kousen

Requires Java 17 or later.

To build the project, use the supplied Gradle wrapper
(no separate Gradle install needed):
> ./gradlew build

To use an IDE, open or import the project as a Gradle project.
IntelliJ IDEA and Eclipse (with Buildship) both do this directly.

The test output is in
build/reports/tests/test/index.html

The weather demo (`src/main/groovy/xml/weather.groovy`) calls
[OpenWeather](https://openweathermap.org/api), so it needs a free API key
in the `OPENWEATHERMAP_API_KEY` environment variable.

Please send any questions or comments to:

Ken Kousen ([email](mailto:ken.kousen@kousenit.com))  
[Kousen IT, Inc.](https://www.kousenit.com)  
[@kenkousen](https://x.com/kenkousen)
