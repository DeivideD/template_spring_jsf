package com.company.project.appinit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import com.company.project.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;




public class AppInit  implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(AppConfig.class);
    ctx.setServletContext(servletContext);
    servletContext.addListener(new ContextLoaderListener(ctx));
    servletContext.addListener(new RequestContextListener());
    Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
    dynamic.addMapping("/");
    dynamic.setLoadOnStartup(1);
  }


}
