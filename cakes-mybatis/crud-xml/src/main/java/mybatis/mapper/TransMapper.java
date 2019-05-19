package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;
import mybatis.domain.QueryTransVO;

/**
 * @author haoc
 */
public interface TransMapper {

  // 插入
  int insertTrans(Trans trans);

  // 并返回主键id
  int insertTransAndIdReturn(Trans trans);

  // 修改
  int updateTrans(Trans trans);

  // 删除
  int deleteTransById(Long id);

  // 查询一条记录
  Trans selectOne(String transId);

  // 基于body的模糊查询
  List<Trans> selectByBody(String body);

  //
  List<Trans> selectByFixedBody(String body);

  // 查询基于查询对象,验证OGNL表达式
  List<Trans> selectByQueryVO(QueryTransVO queryTransVO);

  // 获取全部数据
  int getTotal();
}
