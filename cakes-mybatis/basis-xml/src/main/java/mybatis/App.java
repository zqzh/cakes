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

  // @Test
  // public void noneXml() {
  //   // 手动构建事务, <transactionManager>
  //   TransactionFactory tf = new JdbcTransactionFactory();
  //
  //   // 手动构建数据源, <dataSource>
  //   PooledDataSource ds = new PooledDataSource();
  //   ds.setDriver("com.mysql.cj.jdbc.Driver");
  //   ds.setUsername("root");
  //   ds.setPassword("123456");
  //   ds.setUrl("jdbc:mysql://127.0.0.1:3306/mybatis");
  //
  //   // 创建环境信息类,指明id和事务,数据源
  //   Environment env = new Environment("dev", tf, ds);
  //
  //   // 创建配置类,
  //   Configuration config = new Configuration();
  //
  //   // 设置环境信息
  //   config.setEnvironment(env);
  //
  //   // 添加mapper
  //   config.addMapper(TransMapper.class);
  //
  //   // 构建SqlSessionFactory
  //   SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(config);
  //
  //   // 从工厂中创建SqlSession对象
  //   SqlSession sqlSession = sqlSessionFactory.openSession();
  //
  //   // 使用SqlSession创建TradeDao接口的代理对象
  //   TransMapper transMapper = sqlSession.getMapper(TransMapper.class);
  //
  //   // 由代理对象执行方法
  //   List<BasisXml> basisXmls = transMapper.selectAll();
  //   System.out.println("-------- 准备输出 --------");
  //   basisXmls.forEach(System.out::println);
  //   System.out.println("-------- 结束输出 --------");
  //
  //   // 释放资源
  //   sqlSession.close();
  // }
}
