# basis-xml
> 基础XML,约定大于配置版

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

* 实体: mybatis.domain.Trans
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

* Mapper接口,mybatis.mapper.TransMapper
```java
public interface TransMapper {
  List<Trans> selectAll();
}
```

### 2.TransMapper.xml
* 位置: resources/mybatis/mapper/BasisXmlMapper.xml
* 路径层级和命名要与mybatis.mapper.BasisXmlMapper保持一致
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- namespace要与对应接口的全限定名保持一致 -->
<mapper namespace="mybatis.mapper.TransMapper">

  <!-- id要与接口中的方法名保持一致 -->
  <select id="selectAll" resultType="mybatis.domain.Trans">
    select * from trans;
  </select>
</mapper>
```

### 3.SqlMapConfig.xml
* 位置: resources/SqlMapConfig.xml
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
    <mapper resource="mybatis/mapper/TransMapper.xml"/>
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
    System.out.println(transMapper);

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

### 5.关键配置说明

##### 5.1 不在有MapperImpl类
* 即诸如TransMapperImpl已经不需要
* 为达到不写此实现类的效果,需遵守MyBatis的几条约定,进而可以减少一些必要的操作
* 即:约定大于配置

##### 5.2 Mapper.xml在resources下的路径要与Mapper接口的包名结构一致
* 即: mybatis.mapper.TransMapper.java
* 即: mybatis/mapper/TransMapper.xml
* 若路径不一致将会报错

##### 5.3 Mapper.xml文件中的namespace要与对应接口的类全限定名保持一致
* 即: namespace="mybatis.mapper.TransMapper
* 类: mybatis.mapper.TransMapper.java
* 若不一致则报错
```java
org.apache.ibatis.binding.BindingException: Type interface mybatis.mapper.TransMapper is not known to the MapperRegistry.
```

##### 5.4 select标签的id名称要与接口的方法名保持一致
* 即,select id="selectAll"
* 即,BasisXmlMapper, selectAll();

### 6.MyBatis执行流程梳理

##### 6.1 SqlSessionFactoryBuilder解析SqlMapConfig.xml成org.apache.ibatis.session.Configuration对象
* 使用MyBatis提供的org.apache.ibatis.io.Resources类将文件转成输入流
* 解析出SqlMapConfig.xml文件中配置的数据库连接信息,连接池类型,事务类型等
* 封装Mapper对象组装成一个Map(key=namespace+id, value=Mapper)

##### 6.2 SqlSessionFactoryBuilde基于解析后的Configuration对象创建SqlSessionFactory
* return new DefaultSqlSessionFactory(config);
```java
public class DefaultSqlSessionFactory implements SqlSessionFactory {
  private final Configuration configuration;
  public DefaultSqlSessionFactory(Configuration configuration) {
    this.configuration = configuration;
  }

  // ....略
}
```

##### 6.3 SqlSessionFactory(实例DefaultSqlSessionFactory)基于Configuration中数据库连接信息创建SqlSession实例
* public SqlSession openSession()

##### 6.4 SqlSession的主功能
* 在执行功能之前,需要先拿到SQL语句和数据库连接信息
* 功能点一: 生成接口代理对象
  - sqlSession.getMapper(xxxMapper.class);
  - MyBatis会基于动态代理模式自行实现Mapper接口的实现类完成数据库的CRUD动作
  - 基于Configuration对象创建Connection对象

* 功能点二: 使用通用的CRUD方法(自己实现Mapper实现类)
  - <T> T selectOne(String statement);
  - int insert(String statement, Object parameter);
  - int update(String statement, Object parameter);
  - int delete(String statement, Object parameter);
  - 基于Configuration对象创建Connection对象
  - 使用jdbc的Connection对象完成对应的CRUD操作

##### 6.5 封装结果集
* 基于xml中定义的result* 进行封装
