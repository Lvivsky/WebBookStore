package com.bookstore.servlet;

import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import com.bookstore.service.impl.ProductServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Log4j
@WebServlet("/create-product")
public class CreateProductServlet extends HttpServlet {

    private ProductService productService;

    public CreateProductServlet() {
        this.productService = new ProductServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        log.info("create product servlet");

        try {
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");

            Product product = new Product(name, description, price, "default");
            productService.add(product);

            log.info("product was added");

            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");

            try (PrintWriter writer = resp.getWriter()) {
                writer.write("Success");
            }


        } catch (Exception e) {
            log.error("Erorororororo");
        }
    }
}
