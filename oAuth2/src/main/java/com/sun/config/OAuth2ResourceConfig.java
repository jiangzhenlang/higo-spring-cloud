package com.sun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源访问管理
 * @author 江振朗 2019-07-26
 * @version 0.0.1
 */

@Configuration
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) {
    // todo
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    // todo
  }
}
