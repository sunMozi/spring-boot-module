package com.mozisun.springboottlias.Log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author moZiA
 * @date 2025/5/12 12:41
 * @description
 */
public class LogTests {

  public static final Logger logger = LoggerFactory.getLogger(LogTests.class);


  public static void main(String[] args) {
    logger.trace("trace");
    logger.debug("debug");
    logger.info("info");
    logger.warn("warn");
    logger.error("error");
  }

}