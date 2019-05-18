package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;
import org.apache.ibatis.annotations.Select;

/**
 * @author haoc
 */
public interface TransMapper {

  @Select("select * from trans")
  List<Trans> selectAll();
}
