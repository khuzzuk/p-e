package pl.projectE.ui;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public enum ValueFormatter {
    PERCENT(new DecimalFormat("#0.0")) {
        @Override
        String forNumber(double num) {
            return getFormatter().format(num / 10) + "%";
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
            return levelFormat(n, getFormatter(), 0);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value, 1));
        }
    },
    BIG_DOWNGRADED(new DecimalFormat("#,##0.00")) {
        @Override
        String forNumber(double n) {
            return levelFormat(n, getFormatter(), 1);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value, 1));
        }
    },
    PRECISE(new DecimalFormat("#,##0.00")) {
        @Override
        String forNumber(double num) {
            return getFormatter().format(num / 1000D);
        }

        @Override
        long from(String value) {
            return Math.round(NumberUtils.toDouble(value.replace(",", "")) * 1000);
        }
    },
    SIMPLE(new DecimalFormat("#,##0")) {
        @Override
        String forNumber(double num) {
            return levelFormat(num, getFormatter(), 0);
        }

        @Override
        long from(String value) {
            return Math.round(leveledString(value, 0));
        }
    };
    private static List<String> suffixes = Arrays.asList("", " k", " mln", " bln", " tln", " qln");
    @Getter
    private final DecimalFormat formatter;

    abstract String forNumber(double num);

    abstract long from(String value);

    private static String levelFormat(double n, DecimalFormat formatter, int skip) {
        for (int x = 0; x < suffixes.size() - skip; x++) {
            double a = Math.pow(10, x * 3);
            double b = a * 5000D;
            if (n < b) {
                return formatter.format(n / a) + suffixes.get(x + skip);
            }
        }
        return formatter.format(n);
    }

    private static double leveledString(String value, int skip) {
        Optional<String> suffix = suffixes
                .stream()
                .skip(1)
                .filter(value::contains)
                .findFirst();
        String num = value.replace(",", "").replace(suffix.orElse(""), "");
        int divisor = Math.max(0, suffixes.indexOf(suffix.orElse("")) - 1);
        return NumberUtils.toDouble(num) * Math.pow(10, divisor * 3);
    }
}
