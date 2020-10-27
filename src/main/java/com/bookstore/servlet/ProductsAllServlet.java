package com.bookstore.servlet;

import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import com.bookstore.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j
@WebServlet("/products")
public class ProductsAllServlet extends HttpServlet {

    private ProductService productService;

    public ProductsAllServlet() {
        this.productService = new ProductServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        List<Product> products = productService.getAll();
        String productsJson = new Gson().toJson(products);

        log.info("Count: " + products.size());

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(new Gson().toJson(productsJson));
        } catch (Exception e) {}


    }
}
