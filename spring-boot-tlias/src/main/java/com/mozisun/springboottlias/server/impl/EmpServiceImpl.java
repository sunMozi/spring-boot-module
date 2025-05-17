package com.mozisun.springboottlias.server.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mozisun.springboottlias.mapper.EmpExprMapper;
import com.mozisun.springboottlias.mapper.EmpMapper;
import com.mozisun.springboottlias.model.Dos.EmpListDo;
import com.mozisun.springboottlias.model.Dto.AddEmpDto;
import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.entiry.EmpExpr;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.EmpExprVO;
import com.mozisun.springboottlias.model.vo.ExprVo;
import com.mozisun.springboottlias.server.EmpLogService;
import com.mozisun.springboottlias.server.EmpService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author moZiA
 * @date 2025/5/14 9:16
 * @description
 */
@Service
public class EmpServiceImpl implements EmpService {

  @Resource
  private EmpMapper empMapper;

  @Resource
  private EmpExprMapper empExprMapper;

  @Resource
  private EmpLogService empLogService;

  @Override
  @Transactional
  public void addEmp(AddEmpDto dto) {
    // 1. 校验必填字段（检查非空字段）
    boolean hasNull = BeanUtil.hasNullField(dto,
                                            "job",
                                            "salary",
                                            "gender",
                                            "image",
                                            "entryDate",
                                            "deptId",
                                            "exprList");
    if (hasNull) {
      throw new IllegalArgumentException("必填字段缺失");
    }

    Emp emp = Emp.builder()
                 .password("123456")
                 .createTime(LocalDateTime.now())
                 .updateTime(LocalDateTime.now())
                 .build();
    BeanUtil.copyProperties(dto, emp, "exprList");
    try {
      empMapper.insertEmp(emp);

      if (dto.getExprList() != null && !dto.getExprList().isEmpty()) {
        List<EmpExpr> empExprs = dto.getExprList().stream().map(exprDto -> {
          EmpExpr empExpr = new EmpExpr();
          BeanUtil.copyProperties(exprDto, empExpr);
          empExpr.setEmpId(emp.getId());
          return empExpr;
        }).collect(Collectors.toList());

        empExprMapper.insertBatch(empExprs);
      }
    } finally {
      EmpLog empLog = new EmpLog();
      empLog.setInfo("新增员工：" + emp.toString());
      empLog.setOperateTime(LocalDateTime.now());
      empLogService.insertLog(empLog);
    }
  }

  @Override
  public EmpExprVO getEmpExprById(Integer id) {
    Emp emp = empMapper.selectEmpById(id);
    EmpExprVO empExprVO = new EmpExprVO();
    BeanUtil.copyProperties(emp, empExprVO);

    List<ExprVo> exprVOStream = empExprMapper.selectEmpExprByEmpId(emp.getId())
                                             .stream()
                                             .map(empExpr -> {
                                               ExprVo exprVO = new ExprVo();
                                               BeanUtil.copyProperties(empExpr, empExprVO);
                                               return exprVO;
                                             })
                                             .toList();

    empExprVO.setExprList(exprVOStream);

    return empExprVO;
  }

  @Override
  public PageResult<EmpListDo> page(EmpPageQuery empPageQuery) {
    empPageQuery.checkPageParam();

    PageHelper.startPage(empPageQuery.getPage(), empPageQuery.getPageSize());
    Page<EmpListDo> empListDos = empMapper.selectEmpWithDept(empPageQuery);

    PageResult<EmpListDo> listPageResult = new PageResult<>();
    listPageResult.setRows(empListDos.getResult());
    listPageResult.setTotal(empListDos.getTotal());

    return listPageResult;
  }

  @Override
  public List<Emp> list() {

    return empMapper.selectEmpList();
  }
}