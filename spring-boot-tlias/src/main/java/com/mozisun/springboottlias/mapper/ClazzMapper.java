package com.mozisun.springboottlias.mapper;


import com.github.pagehelper.Page;
import com.mozisun.springboottlias.mapper.sql.ClazzSqlProvider;
import com.mozisun.springboottlias.model.Dos.ClazzListDo;
import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @author moZiA
 * @date 2025/5/11 19:48
 * @description
 */
@Mapper
public interface ClazzMapper {


  @SelectProvider(type = ClazzSqlProvider.class, method = "selectClazzListByClazzName")
  Clazz selectClazzListByClazzName(String clazz);

  @InsertProvider(type = ClazzSqlProvider.class, method = "insertClazz")
  void insertClazz(Clazz clazz);

  @SelectProvider(type = ClazzSqlProvider.class, method = "selectClazzList")
  Page<ClazzListDo> selectClazzList(@Param("clazzPageQuery") ClazzPageQuery clazzPageQuery);

  @DeleteProvider(type = ClazzSqlProvider.class, method = "deleteById")
  Integer deleteById(Integer id);

  @SelectProvider(type = ClazzSqlProvider.class, method = "selectClazzById")
  Clazz selectClazzById(Integer id);

  @UpdateProvider(type = ClazzSqlProvider.class, method = "updateClazz")
  Integer updateClazz(Clazz clazz);
}