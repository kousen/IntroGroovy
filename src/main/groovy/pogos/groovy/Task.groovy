package pogos.groovy

import groovy.transform.Canonical

@Canonical
class Task {
    String name
    int priority
    Date startDate
    Date endDate
    boolean completed
}
