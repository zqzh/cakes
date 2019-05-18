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
