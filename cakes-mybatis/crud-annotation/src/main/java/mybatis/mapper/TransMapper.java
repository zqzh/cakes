package mybatis.mapper;

import java.util.List;
import mybatis.domain.Trans;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author haoc
 */
public interface TransMapper {

  @Insert("INSERT INTO `trans`(`trans_id`, `body`, `subject`, `amount`, `create_time`)  VALUES (#{trans_id}, #{body}, #{subject}, #{amount}, #{create_time})")
  int insertTrans(Trans trans);

  long insertTransAndIdReturn(Trans trans);

  @Update("UPDATE `trans` SET `body`=#{body},`subject`=#{subject},`amount`=#{amount} WHERE `trans_id` = #{trans_id}")
  int updateTrans(Trans trans);

  @Delete("DELETE FROM `trans` WHERE `id` = #{id}")
  int deleteTransById(Long id);

  @Select("SELECT * FROM `trans` WHERE `trans_id` = #{trans_id}")
  Trans selectOne(String transId);

  @Select("SELECT * FROM `trans` WHERE `body` LIKE #{body}")
  List<Trans> selectByBody(String body);

  @Select("SELECT * FROM `trans` WHERE `body` LIKE '%${value}%'")
  List<Trans> selectByFixedBody(String body);

  @Select("SELECT COUNT(*) FROM `trans`")
  int getTotal();
}
