package datetime

import groovy.time.TimeCategory

import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

def ghday = LocalDate.of(2023, Month.FEBRUARY, 2)
def spring = LocalDate.of(2023, Month.MARCH, 20)
long days = spring - ghday
long weeks = ghday.until(spring, ChronoUnit.WEEKS)
println "There are $days between Groundhog Day and the 1st day of Spring"
println "Thats $weeks weeks and ${days - 7 * weeks} days"

// From Paul King (see https://groovy.apache.org/blog/groundhog-day):
var groundHogDay =  LocalDate.of(2023, Month.FEBRUARY, 2)
var springEquinoxNorthernHemisphere = LocalDate.of(2023, Month.MARCH, 20)
var expected = use(TimeCategory) { 6.weeks + 4.days }.days
assert springEquinoxNorthernHemisphere - groundHogDay == expected
