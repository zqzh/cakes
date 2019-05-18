package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;

/**
 * @author haoc
 */
public interface TransMapper {

  int insertTrans(Trans trans);

  int updateTrans(Trans trans);

  int deleteTransById(Long id);

  Trans selectOne(String transId);

  List<Trans> selectMutiple(String body);

  int getTotal();
}
