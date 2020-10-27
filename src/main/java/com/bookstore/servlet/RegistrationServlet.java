package com.bookstore.servlet;

import com.bookstore.model.User;
import com.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bookstore.service.impl.UserServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Random;

@Log4j
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    public RegistrationServlet() {
        userService = new UserServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        log.info("Starting user registration.");

        String email = req.getParameter("email");

        if (Objects.isNull(userService.getUser(email))) {
            log.info("Registration for new user");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String password = req.getParameter("password");

            User user = new User(email, password, firstName, lastName, "default","user");
            userService.create(user);
            log.info("User was registered : " + user);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", firstName);
            session.setAttribute("userEmail", email);

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");

            try (PrintWriter writer = resp.getWriter()) {
                writer.write("Success");
            }
        } else {
            log.error("User with email : " + email + " already registered! Redirection to login page ...");
        }
    }
}
