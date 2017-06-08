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
    CURRENCY(new DecimalFormat("#,##0.00")) {
        private List<String> suffixes = Arrays.asList("", "k", "mln", "bln", "tln", "qln");

        @Override
        String forNumber(double n) {
            for (int x = 0; x < suffixes.size(); x++) {
                double a = Math.pow(10, x * 3);
                double b = a * 5000D;
                if (n < b) {
                    return getFormatter().format(n / a) + suffixes.get(x);
                }
            }
            return getFormatter().format(n);
        }

        @Override
        long from(String value) {

            Optional<String> suffix = suffixes
                    .stream()
                    .skip(1)
                    .filter(value::contains)
                    .findFirst();
            String num = value.replace(",", "").replace(suffix.orElse(""), "");
            return Math.round(NumberUtils.toDouble(num) * Math.pow(10, suffixes.indexOf(suffix.orElse("")) * 3));
        }
    };

    @Getter
    private final DecimalFormat formatter;

    abstract String forNumber(double num);

    abstract long from(String value);
}
