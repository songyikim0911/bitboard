package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;
import org.zerock.bitboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadController", value = "/board/read")
@Log4j2
public class ReadController extends HttpServlet {

    private Integer getInt(String str) {
        try {
            int value = Integer.parseInt(str);
            if (value <= 0) {//페이지값 처리하기
                return null;
            }
            return value;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = getInt(request.getParameter("bno"));
        Integer page = getInt(request.getParameter("page"));
        Integer size = getInt(request.getParameter("size"));
//스프링을 하면 이런 과정을 거칠 필요 X

        PageDTO pageDTO = PageDTO.builder().build();

        if(page != null){ pageDTO.setPage(page);}
        if(size != null){ pageDTO.setSize(size);}


        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("boardDTO", boardDTO);
        request.setAttribute("pageDTO", pageDTO);


        request.getRequestDispatcher("/WEB-INF/board/read.jsp").forward(request, response);


    }

}
