import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class Task {
    String name
    int priority
    LocalDate startDate
    LocalDate endDate
    boolean completed

    String toString() {
        "Task [name=$name, priority=$priority, startDate=$startDate, " +
                "endDate=$endDate, completed=$completed]"
    }
}