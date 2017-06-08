package pl.projectE.ui

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ValueFormatterSpec extends Specification {
    def "format number properly"() {
        when:
        def s = ValueFormatter.CURRENCY.forNumber(number)
        then:
        s == format

        where:
        number                         | format
        1                              | "1.00"
        1000                           | "1,000.00"
        10000                          | "10.00k"
        10_000_000                     | "10.00mln"
        10_000_000_000                 | "10.00bln"
        10_000_000_000_000             | "10.00tln"
        10_000_000_000_000_000         | "10.00qln"
    }

    def "parse number from String"() {
        when:
        def num = ValueFormatter.CURRENCY.from(format)
        then:
        num == number

        where:
        number                         | format
        1                              | "1.00"
        1000                           | "1,000.00"
        10000                          | "10.00k"
        10_000_000                     | "10.00mln"
        10_000_000_000                 | "10.00bln"
        10_000_000_000_000             | "10.00tln"
        10_000_000_000_000_000         | "10.00qln"
    }

    def "format percent"() {
        when:
        def formatted = ValueFormatter.PERCENT.forNumber(1000)

        then:
        formatted == "100.0%"
    }

    def "parse percent"() {
        when:
        def num = ValueFormatter.PERCENT.from("50.0%")

        then:
        num == 500
    }
}
