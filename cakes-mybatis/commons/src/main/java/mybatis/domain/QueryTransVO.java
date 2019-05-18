package mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * trans查询实体,一般用于多个查询参数时,将多个参数包装成一个对象
 *
 * @author haoc
 */
@Setter
@Getter
@ToString
public class QueryTransVO {

  private Trans trans;
}
