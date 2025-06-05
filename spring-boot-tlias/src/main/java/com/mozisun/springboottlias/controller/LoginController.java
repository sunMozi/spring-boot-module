package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dto.EmpLoginDTO;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.EmpLoginVO;
import com.mozisun.springboottlias.properties.JwtProperties;
import com.mozisun.springboottlias.server.LoginService;
import com.mozisun.springboottlias.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户认证模块", description = "员工登录接口")
@RestController
@RequestMapping
@Slf4j
public class LoginController {

  @Resource
  private LoginService loginService;

  @Resource
  private JwtProperties jwtProperties;

  @Operation(summary = "员工登录", description = "使用用户名和密码登录，成功返回 JWT 令牌")
  @PostMapping("/login")
  public Result<EmpLoginVO> login(@RequestBody EmpLoginDTO empLoginDTO) {
    log.info("员工登录：{}", empLoginDTO);
    Emp emp = loginService.login(empLoginDTO);

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
