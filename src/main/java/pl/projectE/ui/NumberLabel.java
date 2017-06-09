package pl.projectE.ui;

import javafx.scene.control.Label;

public class NumberLabel extends Label {
    public long minValue;
    public long maxValue;
    public ValueFormatter formatter;
    private long currentValue;
    public void change(long num) {
        currentValue += num;
        setText(currentValue);
        format();
    }

    public void setText(long value) {
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
