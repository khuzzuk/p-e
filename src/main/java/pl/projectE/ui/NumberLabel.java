package pl.projectE.ui;

import javafx.scene.control.Label;

public class NumberLabel extends Label {
    long minValue;
    long maxValue;
    ValueFormatter formatter;
    private long currentValue;
    void change(long num) {
        currentValue += num;
        setText(currentValue);
        format();
    }

    void setText(long value) {
        currentValue = Long.max(minValue, Long.min(maxValue, value));
        format();
    }

    private void format() {
        setText(formatter.forNumber(currentValue));
    }

    long getIntValue() {
        return formatter.from(getText());
    }
}
