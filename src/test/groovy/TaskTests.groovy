import org.junit.Test

import java.time.LocalDate

class TaskTests {
    LocalDate now = LocalDate.now()
    Task t = new Task(name:'name', priority:3,
            startDate:now, endDate: now + 1, completed: true)

    @Test
    void testToString() {
        assert t.toString() ==
                "Task [name=${t.name}, priority=${t.priority}, " +
                "startDate=$now, endDate=${now+1}, completed=${t.completed}]"
    }

    @Test
    void testGetAndSetName() {
        assert t.name == 'name'
        t.name = 'other'
        assert t.name == 'other'
    }

    @Test
    void testGetAndSetPriority() {
        assert t.priority == 3
        t.priority = 4
        assert t.priority == 4
    }

    @Test
    void testGetAndSetStartDate() {
        LocalDate now = LocalDate.now()
        assert (now >> t.startDate).days == 0
        t.startDate = now + 1
        assert (now >> t.startDate).days == 1
    }

    @Test
    void testGetAndSetEndDate() {
        LocalDate now = LocalDate.now()
        assert (now >> t.endDate).days == 1
        t.endDate = now + 2
        assert (now >> t.endDate).days == 2
    }

    @Test
    void testIsAndSetCompleted() {
        assert t.completed
        t.completed = false
        assert !t.completed
    }
}