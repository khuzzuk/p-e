package pl.projectE.loaders;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LoadersUtil {
    static int loadInt(String data) {
        return Integer.parseInt(data);
    }

    static boolean loadBoolean(String data) {
        return data.equals("1");
    }
}
