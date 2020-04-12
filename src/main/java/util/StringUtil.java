package util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    /**链接数组*/
    public static String toString(String[] array){
        return Stream.of(array).collect(Collectors.joining(","));
    }

    /**下划线转驼峰，如 user_id  转为  userId*/
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        Boolean flag = false;
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                flag = true;
                continue;
            } else {
                if (flag == true) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                    flag = false;
                } else {
                    sb.append(Character.toLowerCase(param.charAt(i)));
                }
            }
        }
        return sb.toString();
    }

    /**驼峰转下划线，如  userId  转为  user_id*/
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if (i!=0) {
                char c = param.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
