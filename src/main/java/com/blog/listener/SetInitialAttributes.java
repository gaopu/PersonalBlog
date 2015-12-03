package com.blog.listener;

import com.blog.dao.ConfigureDao;
import com.blog.dao.ConfigureDaoImp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by geekgao on 15-11-26.
 * serlvetContext生命周期监听器
 * 获取一些配置，放置到context属性中
 */
@WebListener
public class SetInitialAttributes implements ServletContextListener {

    private ConfigureDao configureDao = new ConfigureDaoImp();

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
        servletContextEvent.getServletContext().setAttribute("blogName",configureDao.getConfigured().getHead());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
