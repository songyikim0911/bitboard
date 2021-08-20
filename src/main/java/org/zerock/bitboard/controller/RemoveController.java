package org.zerock.bitboard.controller;

import org.zerock.bitboard.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveController", value = "/board/remove")
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer bno = Integer.parseInt(request.getParameter("bno"));

        BoardService.INSTANCE.remove(bno);

        response.sendRedirect("/board/list");

    }
}
