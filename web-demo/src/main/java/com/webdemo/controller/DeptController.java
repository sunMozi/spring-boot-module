package com.webdemo.controller;

import com.webdemo.pojo.Dept;
import com.webdemo.pojo.Result;
import com.webdemo.server.impl.DeptServerImpl;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Resource
    private DeptServerImpl deptServerImpl;

    @RequestMapping("/depts")
    public Result list2(){
        List<Dept> deptList = deptServerImpl.getDeptList();
        return Result.success(deptList);
    }

}
