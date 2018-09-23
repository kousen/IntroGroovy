package pogos.groovy

import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class Task {
    String name
    int priority
    LocalDate startDate
    LocalDate endDate
    boolean completed
}
