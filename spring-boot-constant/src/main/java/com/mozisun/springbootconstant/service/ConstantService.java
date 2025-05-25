package com.mozisun.springbootconstant.service;


import com.mozisun.springbootconstant.mapper.ConstantMapper;
import com.mozisun.springbootconstant.model.Constant;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/25 15:18
 * @description
 */
@Service
public class ConstantService {

  private final ConstantMapper mapper;
  private static final Map<String, Map<String, Constant>> CACHE = new ConcurrentHashMap<>();

  public ConstantService(ConstantMapper mapper) {
    this.mapper = mapper;
  }

  @PostConstruct
  public void init() {
    List<Constant> list = mapper.selectAllEnabled();
    for (Constant c : list) {
      CACHE.computeIfAbsent(c.getCategoryCode(), k -> new ConcurrentHashMap<>())
           .put(c.getCode(), c);
    }
  }

  /** 获取常量名称 */
  public static String getName(String category, String code) {
    Constant c = Optional.ofNullable(CACHE.get(category)).map(m -> m.get(code)).orElse(null);
    return c != null ? c.getName() : null;
  }

  /** 列出某类别所有常量（按 sortOrder 排序） */
  public static List<Constant> listByCategory(String category) {
    Map<String, Constant> map = CACHE.getOrDefault(category, Collections.emptyMap());
    List<Constant> result = new ArrayList<>(map.values());
    result.sort(Comparator.comparing(Constant::getSortOrder));
    return result;
  }
}