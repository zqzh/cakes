package mybatis.mapper.impl;

import java.util.List;
import mybatis.domain.Trans;
import mybatis.mapper.TransMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author haoc
 */
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
