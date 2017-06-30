package pl.projectE.loaders;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LoadersUtil {
    int loadInt(String data) {
        return Integer.parseInt(data);
    }

    long loadLong(String data) {
        return Long.parseLong(data);
    }

    static boolean loadBoolean(String data) {
        return data.equals("1");
    }
}
