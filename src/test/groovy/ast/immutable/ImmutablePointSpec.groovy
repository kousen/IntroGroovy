package ast.immutable

import spock.lang.Specification

class ImmutablePointSpec extends Specification {
    Point p = new Point(3, 4)

    def "can not change x"() {
        when:
        p.x = 5

        then:
        thrown(ReadOnlyPropertyException)
    }

    def "can not change y"() {
        when:
        p.y = 5

        then:
        thrown(ReadOnlyPropertyException)
    }

    def "can not change x directly"() {
        when:
        p.@x = 5

        then:
        def e = thrown(GroovyRuntimeException)
        e.message == "Cannot set the property 'x' because the backing field is final."
    }

}

