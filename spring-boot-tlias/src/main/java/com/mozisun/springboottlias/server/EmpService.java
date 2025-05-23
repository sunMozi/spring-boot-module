package com.mozisun.springboottlias.server;

import com.mozisun.springboottlias.model.Dos.EmpListDo;
import com.mozisun.springboottlias.model.Dto.AddEmpDto;
import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.EmpExprVO;
import java.util.List;

/**
 * @author MoZi
 * @createTime 2025/5/14 9:16
 */
public interface EmpService {

  PageResult<EmpListDo> page(EmpPageQuery empPageQuery);

  List<Emp> list();

  void addEmp(AddEmpDto addEmpDto);

  EmpExprVO getEmpExprById(Integer id);

  void putEmp(AddEmpDto addEmpDto);

  void delById(Integer... ids);
}
