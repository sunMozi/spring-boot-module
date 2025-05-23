package com.mozisun.springboottlias.server;


import com.github.pagehelper.PageInfo;
import com.mozisun.springboottlias.model.Dos.ClazzListDo;
import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import com.mozisun.springboottlias.model.result.PageResult;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author moZiA
 * @date 2025/5/11 19:49
 * @description
 */
public interface ClazzService {

  PageResult<ClazzListDo> getClazzList(ClazzPageQuery clazzPageQuery);

  void addClazz(Clazz clazz);

  void delById(Integer id);

  Clazz getById(Integer id);

  void putClazz(Clazz clazz);

  List<ClazzListDo> list();
}