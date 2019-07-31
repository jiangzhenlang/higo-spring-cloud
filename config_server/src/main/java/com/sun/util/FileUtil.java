package com.sun.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-30
 * @since 0.0.1
 **/
public class FileUtil {

  public static void main(String[] args) {
    try {
      Map<String, Properties> dev = FileUtil.getProperties("dev");
      Properties properties = dev.get(Constants.consumer);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Map<String, Properties> getProperties(String profilesActive) throws Exception {
//    GitUtil.remoteClone(Constants.username, Constants.password, Constants.remoteRepository, Constants.localRepository);
    File file = new File(Constants.localRepository);
    String[] list = file.list();
    String fileName = null;
    Map<String, Properties> map = new HashMap<>();
    Properties consumerProperties = new Properties();
    for (int i = 0; i < list.length; i++) {
      if ((fileName = ("consumer-client-" + profilesActive + ".properties")).equals(list[i])) {
        consumerProperties.load(new FileInputStream(new File(Constants.localRepository + File.separator + fileName)));
        map.put(Constants.consumer, consumerProperties);
      } else if ((fileName = ("eureka-client-" + profilesActive + ".properties")).equals(list[i])) {
        consumerProperties.load(new FileInputStream(new File(Constants.localRepository + File.separator + fileName)));
        map.put(Constants.eureka_client, consumerProperties);
      }
    }
    return map;
  }


}
