package pl.projectE.math;

public class MathUtils {
    static int sum(int[] array) {
        int n = 0;
        for (int i : array) n += i;
        return n;
    }

    static int average(int... args) {
        if (args.length < 1) return 0;
        return sum(args) / args.length;
    }
}
