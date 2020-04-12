package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectToParmterUtil {

    /**
     *将普通对象动态转为sql参数（必须在实体和数据库表结构完全一样的情况下）
     * 暂不支持时间作为条件
     * @param sql
	 * @param pstat
	 * @param object
     * @return java.sql.PreparedStatement
     * @author Lvxin
     **/
    public static  <T> PreparedStatement getParameterLocation(String sql, PreparedStatement pstat, T object) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        sql = sql.substring(sql.indexOf("where"));
        Class<?> objclass = object.getClass();
        Field[] fields = objclass.getDeclaredFields();
        TreeMap<Integer, Object> dataMap = new TreeMap<>();
        for (Field field : fields) {
            Object value;
            field.setAccessible(true);
            String fieName = field.getName();
            Method method = objclass.getMethod("get" + fieName.substring(0, 1).toUpperCase() + fieName.substring(1));
            value = method.invoke(object);
            if (value != null) {
                int i = sql.indexOf(StringUtil.camelToUnderline(fieName));
                if (i > 0) {
                    dataMap.put(i, value);
                }
            }
        }
        AtomicInteger index = new AtomicInteger(1);
        dataMap.forEach((k, y) -> {
            try {
                if (y instanceof Integer) {
                    pstat.setInt(index.get(), (int) y);
                } else if (y instanceof String) {
                    pstat.setString(index.get(), (String) y);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            index.getAndIncrement();
        });
        return pstat;
    }

}
