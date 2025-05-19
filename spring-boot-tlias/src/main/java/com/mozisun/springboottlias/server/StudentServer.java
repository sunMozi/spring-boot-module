package com.mozisun.springboottlias.server;

import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.StudentVo;

/**
 * @author MoZi
 * @createTime 2025/5/17 18:11
 */
public interface StudentServer {

  PageResult<StudentVo> page(StudentQuery query);
}
