package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import mybatis.domain.Trans;
import mybatis.mapper.TransMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author haoc
 */
public class App {

  private InputStream inputStream;

  private SqlSession sqlSession;

  private TransMapper transMapper;

  @Test
  public void testInsert() {
    Trans trans = new Trans();
    trans.setTrans_id(System.currentTimeMillis() + "");
    trans.setAmount(1024L);
    trans.setBody("其他交易");
    trans.setSubject("支付");
    trans.setCreate_time(new Date());

    int effectRows = transMapper.insertTrans(trans);

    sqlSession.commit();

    Assert.assertEquals(1, effectRows);
  }

  @Test
  public void testUpdate() {
    Trans trans = new Trans();
    trans.setTrans_id("1558017429079");
    trans.setAmount(2048L);
    trans.setBody("其他交易");
    trans.setSubject("支付");

    int effectRows = transMapper.updateTrans(trans);

    sqlSession.commit();

    Assert.assertEquals(1, effectRows);
  }

  @Test
  public void testDelete() {
    int effectRows = transMapper.deleteTransById(7L);

    sqlSession.commit();

    Assert.assertEquals(1, effectRows);
  }

  @Test
  public void testSelectOne() {
    Trans trans = transMapper.selectOne("1558017429079");

    System.out.println(trans);
  }

  @Before
  public void init() throws IOException {
    inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

    // 写法1
    // SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // sqlSession = sessionFactory.openSession();

    // 写法2
    sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();

    transMapper = sqlSession.getMapper(TransMapper.class);
  }

  @After
  public void destory() throws IOException {
    sqlSession.close();
    inputStream.close();
  }

}
