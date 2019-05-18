package jdbc.basis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.consts.JdbcConsts;
import org.junit.Test;

/**
 * 查询
 *
 * 1.为何使用PreparedStatement
 *
 * 2.为PreparedStatement的参数赋值时,索引是从0开始的吗?
 *
 * 3.释放资源时为何先关闭ResultSet
 *
 * @author haoc
 */
public class SelectBasis {

  /**
   * 查询流程,案例代码
   */
  @Test
  public void normal() throws Exception {
    // 1.加载驱动
    Class.forName(JdbcConsts.DRIVER);

    // 2.获取连接
    Connection connection = DriverManager.getConnection(JdbcConsts.URL,
        JdbcConsts.USERNAME,
        JdbcConsts.PASSWORD);

    // 3.预执行SQL
    PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

    // 4.为SQL中的参数赋值,此时无

    // 5.执行查询
    ResultSet resultSet = preparedStatement.executeQuery();

    // 6.处理结果集
    while (resultSet.next()) {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");

      System.out.println("user from db, id=" + id + ", name=" + name);
    }

    // 7.关闭相关资源,注: 倒序关闭
    resultSet.close();
    preparedStatement.close();
    connection.close();
  }

  /**
   * 查询流程,案例代码
   */
  @Test
  public void normal2() throws Exception {
    // 1.加载驱动
    Class.forName(JdbcConsts.DRIVER);

    // 2.获取连接
    Connection connection = DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false",
        "root",
        "123456");

    // 3.预执行SQL
    PreparedStatement preparedStatement = connection.prepareStatement("select *  from user");

    // 4.为SQL中的参数赋值,此时无

    // 5.执行查询
    ResultSet resultSet = preparedStatement.executeQuery();

    // 6.处理结果集
    while (resultSet.next()) {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");

      System.out.println("user from db, id = " + id + ", name = " + name);
    }

    // 7.关闭相关资源,注: 倒序关闭
    resultSet.close();
    preparedStatement.close();
    connection.close();
  }
}
