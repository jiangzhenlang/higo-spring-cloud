package com.sun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 验证中心配置
 * @author 江振朗 2019-07-25
 * @version 0.0.1
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private RedisConnectionFactory redisConnectionFactory;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) {
    // todo
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) {
    // todo
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    // todo
  }

  @Bean
  public RedisTokenStore tokenStore() {
    return new RedisTokenStore(redisConnectionFactory);
  }
}
