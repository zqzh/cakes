# basis-helloworld
> Mybatis,Hello World

---

### 1.新建工程并导入依赖
* gradle 依赖
```groovy
dependencies {
    compile('org.mybatis:mybatis:3.5.1')
    compile('mysql:mysql-connector-java:8.0.13')
}
```

### 2.新建SQL脚本并创建数据库&表
* SQL脚本
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

### 3.建立对应实体
* 实体类mybatis.domain.Trans
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

### 4.创建Mapper接口
* mybatis.mapper.TransMapper接口
```java
public interface TransMapper {
  List<Trans> selectAll();
}
```

* TransMapperImpl
```java
public class TransMapperImpl implements TransMapper {

  private SqlSessionFactory sqlSessionFactory;

  public TransMapperImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Trans> selectAll() {

    // 1.获取SqlSession
    SqlSession sqlSession = this.sqlSessionFactory.openSession();

    // 2.让SqlSession去执行SQL并获取结果
    // statement: 即为 <mapper>标签中的namespace属性值+<select>标签的id值
    List<Trans> trans = sqlSession.selectList("mybatis.hello.world.mapper.hello");

    // 3.关闭SqlSession
    sqlSession.close();

    return trans;
  }
}

```

### 5.建立MyBatis全局配置文件SqlMapConfig.xml
* resource/SqlMapConfig.xml
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
    <!-- 配置资源目录下的mapper映射文件 -->
    <mapper resource="mapper/TransMapper.xml"/>
  </mappers>
</configuration>

```

### 6.在resources下新建Mapper.xml文件
* resource/mapper/TransMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="mybatis.hello.world.mapper">

  <select id="hello" resultType="mybatis.domain.Trans">
    select * from trans;
  </select>
</mapper>
```

### 7.Main程序
* 基于配置文件获取
```java
package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mybatis.domain.Trans;
import mybatis.mapper.TransMapper;
import mybatis.mapper.impl.TransMapperImpl;
import org.apache.ibatis.io.Resources;
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

    // 3.trade接口
    TransMapper transMapper = new TransMapperImpl(sqlSessionFactory);

    // 4.执行
    List<Trans> trans = transMapper.selectAll();
    System.out.println("------- 准备输出 -------");
    trans.forEach(System.out::println);
    System.out.println("------- 结束输出 -------");

    // 5.关闭流
    ins.close();
  }
}
```