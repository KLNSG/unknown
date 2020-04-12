package util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class PassEncryptUtil {

    /**JDK自带的base64加密*/
    public static String getToken(String pass) {
        return new BASE64Encoder().encode(pass.getBytes());
    }

    /**解密*/
    public static String getPass(String token) {
        byte[] str;
        try {
            str = new BASE64Decoder().decodeBuffer(token);
        } catch (IOException e) {
            throw new RuntimeException("密码出错");
        }
        return new String(str);
    }

}
