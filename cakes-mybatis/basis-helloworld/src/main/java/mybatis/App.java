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
