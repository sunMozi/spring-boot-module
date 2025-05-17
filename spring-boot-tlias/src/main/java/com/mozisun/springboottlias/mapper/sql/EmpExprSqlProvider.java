package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.entiry.EmpExpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/14 16:57
 * @description
 */
public class EmpExprSqlProvider {
  public String insertBatch(final Map<String, Object> map) {
    @SuppressWarnings("unchecked")
    List<EmpExpr> empExprs = (List<EmpExpr>) map.get("empExprs");
    if (empExprs == null || empExprs.isEmpty()) {
      throw new IllegalArgumentException("empExprs 不能为空");
    }

    return new SQL() {{
      INSERT_INTO("emp_expr");
      // 一次性指定所有列名
      INTO_COLUMNS("emp_id", "begin", "end", "company", "job");

      // 动态生成多组值
      for (int i = 0; i < empExprs.size(); i++) {
        INTO_VALUES(
            "#{empExprs[" + i + "].empId}",
            "#{empExprs[" + i + "].begin}",
            "#{empExprs[" + i + "].end}",
            "#{empExprs[" + i + "].company}",
            "#{empExprs[" + i + "].job}"
        );
        // 添加逗号分隔（   ）
        if (i < empExprs.size() - 1) {
          ADD_ROW();
        }
      }
    }}.toString();
  }
}