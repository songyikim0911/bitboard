package org.zerock.bitboard.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(filterName ="signin", urlPatterns = {"", ""})
public class SigninFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("Sign in Filter...run...");

        HttpServletRequest req = (HttpServletRequest) request; //다운캐스트
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        //not yet login
        if(session.getAttribute("member") == null){
            res.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);

        //이 메소드로 로그인 처리 가능, 로그인이 안된 사용자들을 걸러낼 수 있다..
        //실행해보면, list는 해당사항없이.. register로 진행 할떄 오류가 남



    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
