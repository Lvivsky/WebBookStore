package com.bookstore.servlet;

import com.bookstore.model.User;
import com.bookstore.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Log4j
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    public LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        User user = userService.getUser(email);

        if (!Objects.isNull(user)) {

            String password = req.getParameter("password");
            if (user.getPassword().equals(password)) {
                log.info("User with email: " + email + " was logged in");

                HttpSession session = req.getSession(true);
                session.setAttribute("userName", user.getFirstName());
                session.setAttribute("userEmail", email);

                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            } else {
                log.error("Wrong password for user with email: " + email);
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } else {
            log.info("User with email : " + email + " is not registered. Redirection to registration page.");
            req.getRequestDispatcher("registration.jsp").forward(req,resp);
        }


    }
}
