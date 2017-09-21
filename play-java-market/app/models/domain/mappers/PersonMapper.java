package models.domain.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import models.domain.Person;

public interface PersonMapper {
	@Select("select * from person where id=#{id}")
	 @Options(flushCache=Options.FlushCachePolicy.TRUE)
	 public Person getById(final int id);

	 @Select("select * from person order by name asc")
	 @Options(flushCache=Options.FlushCachePolicy.TRUE)
	 public List getAll();

	 @Insert("insert into person(name, sex, age, comment) values(#{name}, #{sex}, #{age}, #{comment})")
	 @Options(useGeneratedKeys=true, keyProperty="id")
	 public int append(final Person person);

	 @Update("update person set name=#{name}, sex=#{sex}, age=#{age}, comment=#{comment} where id=#{id}")
	 @Options(flushCache=Options.FlushCachePolicy.TRUE)
	 public int update(final Person person);

	 @Delete("delete from person where id=#{id}")
	 @Options(flushCache=Options.FlushCachePolicy.TRUE)
	 public int remove(@Param("id")final int id);
}
