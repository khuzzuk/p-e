package pl.projectE.math

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MathUtilsSpec extends Specification {
    def "check divider"() {
        when:
        int result = MathUtils.divideUpscale(base, divider)

        then:
        result == expected

        where:
        base              | divider           | expected
        1000              | 2000              | 500
        1000L             | 2000L             | 500
        100               | 200               | 500
        100L              | 200L              | 500
        1                 | 2                 | 499 // correct enough
        1L                | 2L                | 499
        1_000_000_000_000 | 2_000_000_000_000 | 500 // with longs
    }

    def "check multiply percent"() {
        when:
        int result = MathUtils.multiplyPercents(first, second)

        then:
        result == expected

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
        int result = MathUtils.multiplyPercentsPositive(first, second)

        then:
        result == expected

        where:
        first | second | expected
        1000  | 2000   | 3000
        1000  | 1000   | 2000
        1000  | 500    | 1500
        500   | 500    | 750
        500   | 0      | 500
    }

    def "check get by percent"() {
        when:
        int result = MathUtils.getByPercent(number, percent)

        then:
        result == expected

        where:
        number | percent | expected
        1000   | 2000    | 2000
        1000   | 1000    | 1000
        1000   | 500     | 500
        500    | 500     | 250
        500    | 0       | 0
        100000 | 1500    | 150000
    }

    def "check get by percent reversed"() {
        when:
        int result = MathUtils.getByPercentReversed(number, percent)

        then:
        result == expected

        where:
        number | percent | expected
        1000   | 1000    | 0
        1000   | 500     | 500
        500    | 500     | 250
        500    | 0       | 500
        100000 | 990     | 1000
    }

    def "check percent calculation"() {
        when:
        int result = MathUtils.calculatePercentSmall(part, base)

        then:
        result == expected

        where:
        part          | base          | expected
        1000          | 1000          | 1000
        1000          | 500           | 2000
        500           | 1000          | 500
    }

    def "check percent calculation big numbers"() {
        when:
        int result = MathUtils.calculatePercentBig(part, base)

        then:
        result == expected

        where:
        part          | base          | expected
        1_000_000_000 | 2_000_000_000 | 500
        2_000_000_000 | 4_000_000_000 | 500
    }

    def "check multiply with up scaled"() {
        when:
        long result = MathUtils.multiplyWithUpscaled(base, upScaled)

        then:
        result == expected

        where:
        base          | upScaled  | expected
        1_000_000_000 | 1000      | 1_000_000_000
        1_000_000_000 | 500       | 500_000_000
        2_000_000_000 | 2000      | 4_000_000_000
    }

    def "check divide with up scaled"() {
        when:
        long result = MathUtils.divideWithUpScaled(base, upScaled)

        then:
        result == expected

        where:
        base          | upScaled  | expected
        1_000_000_000 | 1000      | 1_000_000_000
        1_000_000_000 | 500       | 2_000_000_000
        2_000_000_000 | 2000      | 1_000_000_000
    }
}
