package com.sun.controller;

import com.sun.service.MockService;
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
  public MockService mockService;

  @RequestMapping("/mock")
  public String mockService(String id){
    System.out.println("0000000000000" + id);
    return mockService.mockService(id);
  }


}
