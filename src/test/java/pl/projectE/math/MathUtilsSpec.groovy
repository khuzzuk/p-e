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

    def "check multiply percent"() {
        when:
        int result = MathUtils.multiplyPercent(first, second);

        then:
        result == expected;

        where:
        first | second | expected
        1000  | 2000   | 2000
        1000  | 1000   | 1000
        1000  | 500    | 500
        500   | 500    | 250
        1000  | 0      | 0
    }

    def "check multiply percent positive"() {
        when:
        int result = MathUtils.multiplyPercentPositive(first, second);

        then:
        result == expected;

        where:
        first | second | expected
        1000  | 2000   | 3000
        1000  | 1000   | 2000
        1000  | 500    | 1500
        500   | 500    | 750
        500   | 0      | 500
    }
}
