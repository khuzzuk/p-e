package pl.projectE.math

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MathUtilsSpec extends Specification {
    def "check divider"() {
        when:
        int result = MathUtils.divideUpscale(base, divider);

        then:
        result == expected;

        where:
        base | divider | expected
        1000 | 2000    | 500
        100  | 200     | 500
        1    | 2       | 499 // correct enough
    }
}
