# jdbc

---

## 1.jdbc 基础
> basis

### 1.1 基本操作流程

##### 1.1.1 数据库&表
* 关系表
```sql
CREATE TABLE IF NOT EXISTS `user`
(
    `id`   BIGINT(20)  NOT NULL DEFAULT 0 COMMENT '自增主键',
    `name` VARCHAR(32) NOT NULL DEFAULT '' COMMENT 'mark 标识'
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT ='trade';

insert into user(id,name) values(1,'jim'),(2,'jack');
```

##### 1.1.2 查询
* jdbc.basis.SelectBasis
```java
@Test
public void normal() throws Exception {
  String sql = "select * from user";
  
  // 1.加载驱动
  Class.forName(JdbcConsts.DRIVER);

  // 2.获取连接
  Connection connection = DriverManager
      .getConnection(JdbcConsts.URL, JdbcConsts.USERNAME, JdbcConsts.PASSWORD);

  // 3.预执行SQL
  PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
```