package com.sun.service.impl;

import com.sun.service.IMockService;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-22
 * @since 0.0.1
 **/
@Service
public class MockServiceImpl implements IMockService {
  @Override
  public String mockService(String id) {
    return "小机灵鬼不错喔:" + id;
  }
}
