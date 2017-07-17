package pl.projectE.math;

class MathUtils {
    static int sum(int[] array) {
        int n = 0;
        for (int i : array) n += i;
        return n;
    }

    static int sum(int[] array, int start, int end) {
        int n = 0;
        for (int i = start; i < end; i++) n += array[i];
        return n;
    }

    static int average(int... args) {
        if (args.length < 1) return 0;
        return sum(args) / args.length;
    }

    static int divideUpscale(int base, int divider) {
        if (divider > 1000) {
            return base / (divider / 1000);
        } else {
            return (int) (((float) base) / (((float) divider) / 1000f));
        }
    }

    static int multiplyPercents(int first, int second) {
        return first * second / 1000;
    }

    static int multiplyPercentsPositive(int first, int second) {
        return multiplyPercents(first, second + 1000);
    }

    static int getByPercent(int number, int percent) {
        if (number > 10000) {
            return (number / 1000) * percent;
        }
        return (number * percent) / 1000;
    }

    static int getByPercentReversed(int number, int percent) {
        if (percent > 1000) {
            throw new IllegalArgumentException("percent is more than 100%");
        }
        if (number > 10000) {
            return (number / 1000) * (1000 - percent);
        }
        return (number * (1000 - percent)) / 1000;
    }
}
