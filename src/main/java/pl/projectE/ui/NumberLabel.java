package pl.projectE.ui;

import javafx.scene.control.Label;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.DecimalFormat;

public class NumberLabel extends Label {
    long minValue;
    long maxValue;
    long divider;
    String suffix;
    DecimalFormat format;
    long currentValue;
    void change(long num) {
        currentValue = Long.max(minValue, Long.min(maxValue, currentValue + num));
        format();
    }

    void setText(long value) {
        currentValue = value;
        format();
    }

    private void format() {
        setText(format.format(((double)currentValue) / divider) + suffix);
    }

    long getIntValue() {
        return Math.round(NumberUtils.toDouble(getText().replace(suffix, "")) * divider);
    }
}
