package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;

/**
 * @author haoc
 */
public interface TransMapper {
  List<Trans> selectAll();
}
