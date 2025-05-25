package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.mapper.EmpMapper;
import com.mozisun.springboottlias.model.Dto.EmpLoginDTO;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.server.LoginService;
import jakarta.annotation.Resource;
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
    return empMapper.selectEmpByUserNameAndPassWord(empLoginDTO.getUsername(),
                                                    empLoginDTO.getPassword());
  }
}