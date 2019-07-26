package com.sun.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description
 * @author: suntaozhang
 * @create: 2019-07-25
 * @since 0.0.1
 **/
@Component
public class MyFilter extends ZuulFilter {

  @Override
  public String filterType() {
    //pre：路由之前
//		routing：路由之时
//		post： 路由之后
//		error：发送错误调用
    return "pre";
  }

  /**
   * 过滤的顺序
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 这里可以写逻辑判断，是否要过滤，true为永远过滤。
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }


  /**
   * 过滤器的具体逻辑
   */
  @Override
  public Object run() throws ZuulException {
    RequestContext currentContext = RequestContext.getCurrentContext();
    HttpServletRequest request = currentContext.getRequest();
    String name = request.getParameter("id");
    if (name != null && name.equals("11")) {
      //zuul直接响应
      currentContext.setSendZuulResponse(false);
      currentContext.getResponse().setContentType("text/html;charset=utf-8");
      try {
        currentContext.getResponse().getWriter().write("拦截不允许");
      } catch (IOException e) {
          e.printStackTrace();
      }
      return null;
    }
    return null;
  }


}
