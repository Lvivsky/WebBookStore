package com.bookstore.servlet;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Log4j
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();

        if (session != null) {
            String userEmail = (String) session.getAttribute("userEmail");
            log.info("User with email : " + userEmail + " trying to logout");

            session.invalidate();

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            try (PrintWriter writer = resp.getWriter()) {
                writer.write("Success");
            }
        }
    }
}
