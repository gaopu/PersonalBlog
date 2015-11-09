package com.blog.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by geekgao on 15-10-16.
 */
public class EncodingFilter implements Filter {

    private String encoding;

    /**
     * 获取配置的默认编码
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    /**
     * 设置客户端向服务器提交数据的默认编码
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
