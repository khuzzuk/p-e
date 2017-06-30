package pl.projectE.loaders;

public class LoadersUtil {
    static int loadInt(String data) {
        return Integer.parseInt(data);
    }

    static long loadLong(String data) {
        return Long.parseLong(data);
    }

    static boolean loadBoolean(String data) {
        return data.equals("1");
    }
}
