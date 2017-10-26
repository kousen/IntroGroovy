import groovy.transform.Canonical

@Canonical
class Task {
    String name
    int priority
    Date startDate
    Date endDate
    boolean completed

    String toString() {
        "Task [name=$name, priority=$priority, startDate=$startDate, " +
                "endDate=$endDate, completed=$completed]"
    }
}