package com.blog.listener;

import com.blog.mapper.ConfigureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by geekgao on 15-11-26.
 * serlvetContext生命周期监听器
 * 获取一些配置，放置到context属性中
 */
@Component
@WebListener
public class SetInitialAttributes implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            //将博客名称放置到属性中
            setBlogName(servletContextEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setBlogName(ServletContextEvent servletContextEvent) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");
        ConfigureMapper configureMapper = (ConfigureMapper) applicationContext.getBean("configureMapper");
        servletContextEvent.getServletContext().setAttribute("blogName",configureMapper.getConfigured().getHead());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
