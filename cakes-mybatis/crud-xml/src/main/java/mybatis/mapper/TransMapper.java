package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;
import mybatis.domain.QueryTransVO;

/**
 * @author haoc
 */
public interface TransMapper {

  int insertTrans(Trans trans);

  int insertTransAndIdReturn(Trans trans);

  int updateTrans(Trans trans);

  int deleteTransById(Long id);

  Trans selectOne(String transId);

  List<Trans> selectByBody(String body);

  List<Trans> selectByFixedBody(String body);

  List<Trans> selectByQueryVO(QueryTransVO queryTransVO);

  int getTotal();
}
