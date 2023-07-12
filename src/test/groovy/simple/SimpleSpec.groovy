package simple

import spock.lang.Specification

class SimpleSpec extends Specification {

    def 'there are four lights'() {
        expect:
        2 + 2 == 4
    }

    def 'when I append to a list, the number of items goes up by 1'() {
        given:
        def list = [1, 2, 3]
        // def originalSize = list.size()

        when:
        list << 4

        then:
        list.size() == old(list.size()) + 1
    }
}
