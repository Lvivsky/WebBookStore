package com.bookstore.servlet;

import com.bookstore.model.User;
import com.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Log4j
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    public RegistrationServlet(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Start registration user");

        String email = req.getParameter("email");

        if (Objects.isNull(userService.getUser(email))) {
            log.info("Registration for new user");
            String password = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");

            if (!email.isEmpty() &&
                    !password.isEmpty() &&
                    !firstName.isEmpty() &&
                    !lastName.isEmpty() &&
                    password.equals(confirmPassword)
            ) {
                User user = new User(null, email, password, firstName, lastName, "user");
                userService.create(user);
                log.info("User was created : " + user);

                HttpSession session = req.getSession(true);
                session.setAttribute("userName", firstName);
                session.setAttribute("userEmail", email);

                req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
            }
        } else {
            log.info("User with email : " + email + " already registered! Redirection to login page ...");
        }


    }
}
