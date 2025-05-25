package com.mozisun.springboottlias.server;

import com.mozisun.springboottlias.model.Dto.EmpLoginDTO;
import com.mozisun.springboottlias.model.entiry.Emp;

/**
 * @author MoZi
 * @createTime 2025/5/23 17:58
 */
public interface LoginService {

  Emp login(EmpLoginDTO empLoginDTO);
}
