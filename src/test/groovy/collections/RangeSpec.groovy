package collections

import spock.lang.Specification
import spock.lang.Unroll

class RangeSpec extends Specification {
    private final static int MIN = 1
    private final static int MAX = 5

    @Unroll
    def 'value of #n between MIN and MAX'() {
        expect:
        new MyClass(p:n).validate()

        where:
        //n << new IntRange(MIN, MAX)
        //n << MIN..MAX
        n << (MIN..MAX)
    }

    class MyClass {
        int p

        boolean validate() {
            p in MIN..MAX
        }
    }
}
