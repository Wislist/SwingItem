package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static JdbcUtils instance;

    DataSource dataSource;


    /**
     * TODO:获取当前类的实例对象
     *
     * @return
     */
    public static JdbcUtils getInstance() {
        if (null == instance) {
            instance = new JdbcUtils();
        }
        return instance;
    }

    /**
     * TODO:读取配置文件
     */
    private JdbcUtils() {
        //数据源配置
        Properties prop = new Properties();
        //读取配置文件
        InputStream is = JdbcUtils.class.getResourceAsStream("/druid.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //返回的是DataSource
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**关闭链接
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
