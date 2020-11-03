package misc


import spock.lang.Requires
import spock.lang.Specification
import spock.lang.Unroll

@Requires({ os.macOs || os.linux })
class JumbleSpec extends Specification {

    @Unroll
    void "unscramble #scrambled to get #word"() {
        given:
        Jumble1 jumble1 = new Jumble1()
        Jumble2 jumble2 = new Jumble2()

        expect:
        jumble1.solve(scrambled) == word
        jumble2.solve(scrambled) == word

        where:
        scrambled || word
        'cautla'  || 'actual'
        'agileo'  || 'goalie'
        'mmlueb'  || 'mumble'
    }
}
