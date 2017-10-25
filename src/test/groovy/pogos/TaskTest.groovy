package pogos

import org.junit.Test
import pogos.groovy.Task

import static org.junit.Assert.*

class TaskTest {
    Date now = new Date()
    Date then = now + 1  // now.plus(1)
    Task t = new Task(name: 'name', priority: 3,
        startDate: now, endDate: then)

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
    void testEquality() {
        Task t1 = new Task(name: 'name', priority: 3,
            startDate: now, endDate: then)
        assert t == t1
        t1.completed = true
        assert !(t == t1)
    }

    @Test
    void testEqualsAndHashCode() {
        Task t1 = new Task(name: 'name', priority: 3,
                startDate: now, endDate: then)
        Set tasks = [t, t1]
        assert tasks.size() == 1
    }
}
