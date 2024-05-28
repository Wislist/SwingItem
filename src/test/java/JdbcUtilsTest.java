import Utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        JdbcUtils jdbcUtils = JdbcUtils.getInstance();
        Connection connection = jdbcUtils.getConnection();

        if (connection != null) {
            System.out.println("数据库连接成功！");
            try {
                // 连接成功后可以进行一些操作
                // 例如查询数据库信息或执行一些SQL语句
                // 这里可以添加你的测试代码
                // 示例：执行查询操作
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM kc");
                // 处理结果集
                while (resultSet.next()) {
                    // 处理每一行数据
                }
                // 关闭结果集和语句
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("数据库连接失败！");
        }
    }
}
