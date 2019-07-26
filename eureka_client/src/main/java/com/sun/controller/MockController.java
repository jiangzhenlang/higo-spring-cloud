package com.sun.controller;

import com.sun.service.IMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-22
 * @since 0.0.1
 **/
@RestController
public class MockController {

  @Autowired
  public IMockService mockService;

  @RequestMapping("/mock")
  public String mockService(String id){
    System.out.println("fd" + id);
    return mockService.mockService(id);
  }


}
