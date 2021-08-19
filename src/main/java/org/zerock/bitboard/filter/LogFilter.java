package org.zerock.bitboard.filter;


import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
@Log4j2
public class LogFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("------------------");
        log.info("------------------");
        log.info("init filter");
        log.info("------------------");
        log.info("------------------");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //servelet request>>http request 좀 더 상위개념의 매개변수를 사용한다는것.

        //filterchain는 걸리고 나서 다음에 어디로 보낼건지 정하는것.
        log.info("doFilter...................");
        log.info("doFilter...................");
        log.info("doFilter...................");
        log.info("doFilter...................");

        request.setCharacterEncoding("UTF-8");//필터에서 한글처리를다해줄수있다.

        chain.doFilter(request, response);//이제 다음페이지로 보냄.

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
