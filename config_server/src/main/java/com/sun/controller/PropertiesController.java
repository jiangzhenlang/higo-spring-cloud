package com.sun.controller;

import com.sun.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


}
