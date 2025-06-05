package com.mozisun.springboottlias.server;


import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.Dept;
import com.mozisun.springboottlias.model.result.PageResult;
import java.util.List;

/**
 * @author moZiA
 * @date 2025/5/11 11:21
 * @description
 */
public interface DeptServer {

  void addDept(Dept dept);

  void delById(Integer id);

  PageResult<Dept> deptAll(PageQuery query);

  Dept getDeptById(Integer id);

  void putDept(Dept dept);

  List<Dept> deptList();
}