package com.sun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-22
 * @since 0.0.1
 **/
@FeignClient(value = "eureka-client")
public interface MockService {

  @RequestMapping(value = "/mock")
  String mockService(@RequestParam("id") String id);

}
