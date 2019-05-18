# basis-annotation
> 基础注解版实现

---

### 1.初始化
* SQL
```sql
CREATE DATABASE mybatis;

USE mybatis;

CREATE TABLE IF NOT EXISTS `trans`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `trans_id`    VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '交易单号,唯一',
    `body`        VARCHAR(128)        NOT NULL DEFAULT '' COMMENT '描述',
    `subject`     VARCHAR(128)        NOT NULL DEFAULT '' COMMENT '标题',
    `amount`      BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '交易金额,单位:分',
    `create_time` DATETIME            NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='交易信息表';

INSERT INTO `trans`(`trans_id`, `body`, `subject`, `amount`)
VALUES ('10011000', '微信交易', '支付', 512),
       ('10011001', '支付宝交易', '支付', 1024),
       ('10011002', '易宝支付交易', '支付', 2048),
       ('10011003', '微信交易', '支付', 4096);
```

* 实体类,mybatis.domain.Trans
```java
public class Trans {

  private Long id;
  private String trans_id;
  private String body;
  private String subject;
  private Long amount;
  private Date create_time;

}
```

### 2.Mapper接口
* mybatis.mapper.TransMapper
* 注解: @Select
```java
public interface TransMapper {

  @Select("select * from trans")
  List<Trans> selectAll();
}
```

### 3.SqlMapConfig.xml
* 主要是mapper标签的资源不再是resource,而是变为了class
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!-- 配置的根节点 -->
<configuration>

  <!-- 环境配置 -->
  <environments default="dev">

    <!-- 开发环境:可以配置多个environment节点,用于维护多套环境 -->
    <environment id="dev">

      <!-- 配置事务的类型 -->
      <transactionManager type="JDBC">
      </transactionManager>

      <!-- 配置数据源,取值有三个,POOLED:池 -->
      <dataSource type="POOLED">
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://127.0.0.1:3306/mybatis"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
      </dataSource>
    </environment>
  </environments>

  <!-- 指定映射的配置文件所在的路径 -->
  <mappers>

    <!-- 此时使用注解,则选择class属性直接定位Mapper类 -->
    <mapper class="mybatis.mapper.TransMapper"/>
  </mappers>
</configuration>

```

### 4.Main程序
```java
package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mybatis.domain.Trans;
import mybatis.mapper.TransMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author haoc
 */
public class App {

  @Test
  public void normal() throws IOException {
    // 1.读取配置
    InputStream ins = Resources.getResourceAsStream("SqlMapConfig.xml");

    // 2.构建SqlSessionFactory工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);

    // 3.从工厂中创建SqlSession对象
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 4.使用SqlSession创建TradeDao接口的代理对象
    TransMapper transMapper = sqlSession.getMapper(TransMapper.class);

    // 5.由代理对象执行方法
    List<Trans> trans = transMapper.selectAll();
    System.out.println("------- 准备输出 -------");
    trans.forEach(System.out::println);
    System.out.println("------- 结束输出 -------");

    // 6.释放资源
    sqlSession.close();

    ins.close();
  }
}

```