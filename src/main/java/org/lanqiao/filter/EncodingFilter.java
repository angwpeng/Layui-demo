package org.lanqiao.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    String  encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("Encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      response.setContentType("text/html; charset="+encoding);
        response.setCharacterEncoding(encoding);
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
