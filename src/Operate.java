import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 * Operate 对应  Operate（业务处理类）：定义每一个具体操作的方法
 */
public class Operate {
        PreparedStatement pstmt;
        Connection conn=getConn();
        public Connection getConn() {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://49.234.72.114:3306/gzy?&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "gzy112480..";
            Connection conn = null;
            try {
                Class.forName(driver); //classLoader,加载对应驱动
                conn = (Connection) DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
}
