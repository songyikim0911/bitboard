package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.bitboard.dao.BoardDAO;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyController", value="/board/modify")
@Log4j2
public class ModifyController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = Integer.parseInt(request.getParameter("bno"));



        request.setAttribute("bno", bno);
        request.getRequestDispatcher("/WEB-INF/board/modify.jsp").forward(request,response);

    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = Integer.parseInt(request.getParameter("bno"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");


        BoardDTO dto = BoardDTO.builder()
                   .bno(bno)
                .title(title)
                    .content(content)
                    .build();


            BoardService.INSTANCE.modify(dto);


            response.sendRedirect("/board/read?bno=" + bno);

        }
}
