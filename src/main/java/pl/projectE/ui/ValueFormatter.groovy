package pl.projectE.ui

import groovy.transform.CompileStatic
import org.apache.commons.lang3.math.NumberUtils

import java.text.DecimalFormat

@CompileStatic
enum ValueFormatter {
    PERCENT(new DecimalFormat("#0.0")) {
        @Override
        String forNumber(double num) {
            return formatter.format(num / 10) + "%";
        }

        @Override
        long from(String value) {
            String s = value.replace("%", "");
            if (NumberUtils.isParsable(s)) {
                return Math.round(NumberUtils.toDouble(s) * 10);
            }
            return 0;
        }
    },
    BIG(new DecimalFormat("#,##0.00")) {
        @Override
        String forNumber(double n) {
            return levelFormat(n);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value));
        }
    },
    BIG_DOWNGRADED(new DecimalFormat("#,##0.00")) {
        @Override
        String forNumber(double n) {
            return levelFormat(n, 1);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value, 1));
        }
    },
    PRECISE(new DecimalFormat("#,##0.00")) {
        @Override
        String forNumber(double num) {
            return formatter.format(num / 1000D);
        }

        @Override
        long from(String value) {
            return Math.round(NumberUtils.toDouble(value.replace(",", "")) * 1000);
        }
    },
    SIMPLE(new DecimalFormat("#,##0")) {
        @Override
        String forNumber(double num) {
            return levelFormat(num);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value));
        }
    }

    private static List<String> suffixes = Arrays.asList("", " k", " mln", " bln", " tln", " qln");
    protected DecimalFormat formatter;

    ValueFormatter(DecimalFormat formatter) {
        this.formatter = formatter
    }

    abstract String forNumber(double num);

    abstract long from(String value);

    protected String levelFormat(double n, int skip = 0) {
        for (int x = 0; x < suffixes.size() - skip; x++) {
            double a = Math.pow(10, x * 3);
            double b = a * 5000D;
            if (n < b) {
                return formatter.format(n / a) + suffixes.get(x + skip);
            }
        }
        return formatter.format(n);
    }

    private static double leveledString(String value, int skip = 0) {
        Optional<String> suffix = suffixes
                .stream()
                .skip(1)
                .filter({value.contains(it)})
                .findFirst()
        def num = value.replace(",", "").replace(suffix.orElse(""), "")
        int divisor = Math.max(0, suffixes.indexOf(suffix.orElse("")) - skip)
        return NumberUtils.toDouble(num) * Math.pow(10, divisor * 3)
    }
}
