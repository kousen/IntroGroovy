package metaprogramming

import java.time.LocalDate
import java.time.Month
import java.time.temporal.ChronoUnit

LocalDate.metaClass.minus = { LocalDate date ->
    date.until(delegate, ChronoUnit.DAYS)
}

LocalDate electionDay = LocalDate.of(2016, Month.NOVEMBER, 8)
LocalDate today = LocalDate.now()

println "${electionDay - today} days to go"