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
}
