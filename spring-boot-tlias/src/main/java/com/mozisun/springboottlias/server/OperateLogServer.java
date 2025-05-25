package com.mozisun.springboottlias.server;

import com.mozisun.springboottlias.model.entiry.OperateLog;

/**
 * @author MoZi
 * @createTime 2025/5/23 17:52
 */
public interface OperateLogServer {

  void insertOperateLog(OperateLog build);
}
