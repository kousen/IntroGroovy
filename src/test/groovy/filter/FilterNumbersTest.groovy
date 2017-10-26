package filter

import spock.lang.Specification

class FilterNumbersTest extends Specification {
    FilterNumbers app = new FilterNumbers()

    def "find all positives out of a list of only positives"() {
        when:
        Collection positives = app.findPositives(3, 1, 4, 1, 5, 9)

        then:
        positives.every { it > 0 }
    }

    def "find all positives out of a list of only negatives"() {
        when:
        Collection positives = app.findPositives(-10..-1 as Integer[])

        then:
        positives.every { it > 0 }
    }

    def "find all positives out of a list of positives and negatives"() {
        when:
        Collection positives = app.findPositives(-5..5 as Integer[])

        then:
        positives.every { it > 0 }
    }

}
