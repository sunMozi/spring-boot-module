package com.mozisun.springboottlias.server;


import com.mozisun.springboottlias.model.result.Result;

/**
 * @author moZiA
 * @date 2025/5/18 19:59
 * @description
 */
public interface ReportServer {

  Result<?> empGenderData();

  Result<?> empJobData();

  Result<?> studentDegreeData();

  Result<?> studentCountData();
}