package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.util.Constants;
import com.sun.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-30
 * @since 0.0.1
 **/
@Controller
@RequestMapping("/properties")
public class PropertiesController {

  @RequestMapping(value = "/dev", method = RequestMethod.GET)
  public String properties(Model model) {
    try {
      Map<String, Properties> properties = FileUtil.getProperties("dev");
      model.addAttribute("properties", properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "properties";
  }


  @RequestMapping(value = "/update/consumer/dev")
  public void update(HttpServletRequest request) {
    try {
      InputStream inputStream = request.getInputStream();
      byte[] bytes = new byte[1024];
      StringBuffer stringBuffer = new StringBuffer();
      while (inputStream.read(bytes) != -1) {
        stringBuffer.append(new String(bytes));
      }
      JSONObject jsonObject = JSONObject.parseObject(stringBuffer.toString());
      Map<String, Properties> properties = FileUtil.getProperties("dev");
        for (String jb : jsonObject.keySet()) {
          Properties properties1 = properties.get(Constants.consumer);
          properties1.put(jb, jsonObject.get(jb));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
