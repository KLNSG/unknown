package util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    public static String toString(String[] array){
        return Stream.of(array).collect(Collectors.joining(","));
    }

}
