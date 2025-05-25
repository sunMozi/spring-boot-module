package com.mozisun.springbootconstant.mapper;


import com.mozisun.springbootconstant.model.Constant;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author moZiA
 * @date 2025/5/25 15:18
 * @description
 */
@Mapper
public interface ConstantMapper {

  List<Constant> selectAllEnabled();

  List<Constant> selectByCategory(String category);
}