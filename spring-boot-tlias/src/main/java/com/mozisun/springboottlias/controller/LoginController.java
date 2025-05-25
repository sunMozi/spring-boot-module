package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dto.EmpLoginDTO;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.EmpLoginVO;
import com.mozisun.springboottlias.properties.JwtProperties;
import com.mozisun.springboottlias.server.LoginService;
import com.mozisun.springboottlias.utils.JwtUtils;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/23 17:57
 * @description
 */
@RestController
@RequestMapping
@Slf4j
public class LoginController {

  @Resource
  private LoginService loginService;

  @Resource
  private JwtProperties jwtProperties;


  @PostMapping("/login")
  public Result<EmpLoginVO> login(@RequestBody EmpLoginDTO empLoginDTO) {
    log.info("员工登录：{}", empLoginDTO);
    Emp emp = loginService.login(empLoginDTO);
    //登录成功后，生成jwt令牌
    Map<String, Object> claims = new HashMap<>();
    claims.put("emp_id", emp.getId());
    String token = JwtUtils.createJWT(jwtProperties.getAdminSecretKey(),
                                      jwtProperties.getAdminTtl(),
                                      claims);
    EmpLoginVO employeeLoginVO = EmpLoginVO.builder()
                                           .id(emp.getId())
                                           .userName(emp.getUsername())
                                           .name(emp.getName())
                                           .token(token)
                                           .build();
    return Result.success(employeeLoginVO);
  }


}