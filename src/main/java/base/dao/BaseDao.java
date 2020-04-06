package base.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类一般写出静态 或被其他使用者继承
 * */
public class BaseDao {
    private static String driver="";
    private static String url="";
    private static String user="";
    private static String pwd="";
    private static DataSource dataSource;
    private static ComboPooledDataSource dataSourceP0;

    public Connection con=null;
    public PreparedStatement pstat=null;
    public ResultSet rs=null;

    static {
        try {
            init();
            dataSourceP0=new ComboPooledDataSource();
            dataSourceP0.setDriverClass(driver);
            dataSourceP0.setJdbcUrl(url);
            dataSourceP0.setUser(user);
            dataSourceP0.setPassword(pwd);
            dataSourceP0.setMaxPoolSize(30);
            dataSourceP0.setMinPoolSize(10);
            dataSourceP0.setMaxIdleTime(2000);
        }  catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    //单线程的一个容器
    static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();

    //设置是否自动提交
    public static void setAutoCommit(boolean flag){
        try {
            if(threadLocal.get()!=null){
                threadLocal.get().setAutoCommit(flag);
            }else{
                getConnection().setAutoCommit(flag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Commit(){
        try {
            threadLocal.get().commit();
            setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void rollback(){
        try {
            threadLocal.get().rollback();
            setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据初始化
     * BaseDao jdbc 属性初始化
     * */
    public static  void init(){
        Properties params =new Properties();
        InputStream input=BaseDao.class.
                getClassLoader().getResourceAsStream("database.properties");
        try {
            params.load(input);
            driver= params.getProperty("driver");
            url=params.getProperty("url");
            user=params.getProperty("username");
            pwd=params.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {

        try {
            return  dataSourceP0.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param conn 连接对象
     * */
    public void closeAll(Connection conn,
                         Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null) resultSet.close();
            if(statement!=null) statement.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 所有数据增删改的通用方法  区别只是 sql 和参数不一样
     * @param sql 增删改的语句
     * @param params 增删改的参数
     * */
    public int executeUpdate(String sql,Object[] params){
        Connection conn=null;
        PreparedStatement pre=null;
        try {
            conn=getConnection();
            pre=conn.prepareStatement(sql);
            if(params!=null){
                for (int i = 0; i <params.length ; i++) {
                    pre.setObject(i+1,params[i]);
                }
            }
            return  pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(null,pre,null);
        }
        return  -1;
    }





}
