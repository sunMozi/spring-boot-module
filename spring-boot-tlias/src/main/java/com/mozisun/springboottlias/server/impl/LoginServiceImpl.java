package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.header.enums.CommonExceptionEnum;
import com.mozisun.springboottlias.header.exception.BizException;
import com.mozisun.springboottlias.header.exception.ExceptionCase;
import com.mozisun.springboottlias.mapper.EmpMapper;
import com.mozisun.springboottlias.model.Dto.EmpLoginDTO;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.server.LoginService;
import jakarta.annotation.Resource;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/23 17:58
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Resource
  private EmpMapper empMapper;

  @Override
  public Emp login(EmpLoginDTO empLoginDTO) {
    // 参数校验
    if (empLoginDTO == null || empLoginDTO.getUsername() == null ||
        empLoginDTO.getUsername().isBlank() || empLoginDTO.getPassword() == null ||
        empLoginDTO.getPassword().isBlank()) {
      ExceptionCase.cast(CommonExceptionEnum.USERNAME_OR_PASSWORD_INVALID);
    }

    // 根据用户名查询用户（假设此方法只根据用户名查询，密码单独比对）
    Optional<Emp> empOpt = Optional.ofNullable(empMapper.selectEmpByUserName(empLoginDTO.getUsername()));

    // 用户不存在，抛异常
    Emp emp = empOpt.orElseThrow(() -> new BizException(CommonExceptionEnum.USER_NOT_EXIST));

    // TODO: 密码加密比对（此处示例为明文对比，实际应用 BCrypt 或其他加密算法）
    if (!emp.getPassword().equals(empLoginDTO.getPassword())) {
      ExceptionCase.cast(CommonExceptionEnum.USER_PASSWORD_ERROR);
    }

    emp.setPassword(null);
    return emp;
  }

}