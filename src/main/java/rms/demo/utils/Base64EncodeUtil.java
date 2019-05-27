package rms.demo.utils;

import java.util.Base64;

/**
 * @author : Meredith
 * @date : 2019-05-27 16:33
 * @description :
 */
public class Base64EncodeUtil {

    public static String encoding(String str) {
        return Base64.getEncoder().withoutPadding().encodeToString(str.getBytes());
    }
}
