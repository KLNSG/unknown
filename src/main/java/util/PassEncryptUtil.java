package util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    /**md5加密*/
    public static String md5(String password) {
        String md5After="";
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("密码异常");
        }
        byte[] digest = md5.digest(password.getBytes());
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<digest.length;i++){
            byte b = digest[i];
            builder.append(String.format("%02X",b));
        }
        md5After=builder.toString().toLowerCase();
        return md5After;
    }

}
