package pl.projectE.ui

import spock.lang.Specification
import spock.lang.Unroll

import static ValueFormatter.BIG
import static ValueFormatter.PRECISE
import static ValueFormatter.PERCENT
import static ValueFormatter.SIMPLE

@Unroll
class ValueFormatterSpec extends Specification {
    def "format number properly"() {
        when:
        def s = BIG.forNumber(number)
        then:
        s == format

        where:
        number                         | format
        1                              | "1.00"
        1000                           | "1,000.00"
        10000                          | "10.00 k"
        10_000_000                     | "10.00 mln"
        10_000_000_000                 | "10.00 bln"
        10_000_000_000_000             | "10.00 tln"
        10_000_000_000_000_000         | "10.00 qln"
    }

    def "parse number from String"() {
        when:
        def num = BIG.from(format)
        then:
        num == number

        where:
        number                         | format
        1                              | "1.00"
        1000                           | "1,000.00"
        10000                          | "10.00 k"
        10_000_000                     | "10.00 mln"
        10_000_000_000                 | "10.00 bln"
        10_000_000_000_000             | "10.00 tln"
        10_000_000_000_000_000         | "10.00 qln"
    }

    def "format percent"() {
        when:
        def formatted = PERCENT.forNumber(1000)

        then:
        formatted == "100.0%"
    }

    def "parse percent"() {
        when:
        def num = PERCENT.from("50.0%")

        then:
        num == 500
    }

    def "parse currency precise"() {
        when:
        def formatted = PRECISE.forNumber(number)
        def num = PRECISE.from(format)

        then:
        formatted == format
        num == number

        where:
        number         | format
        40             | "0.04"
        40_000         | "40.00"
        40_000_000     | "40,000.00"
        40_000_000_000 | "40,000,000.00"
    }

    def "parse simple"() {
        when:
        def formatted = SIMPLE.forNumber(number)
        def num = SIMPLE.from(format)

        then:
        formatted == format
        num == number

        where:
        number         | format
        40             | "40"
        40_000         | "40 k"
        40_000_000     | "40 mln"
        40_000_000_000 | "40 bln"
    }
}
