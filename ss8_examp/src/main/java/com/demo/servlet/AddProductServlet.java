package com.demo.servlet;

import com.demo.dao.ProductDao;
import com.demo.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/adminaddproduct"})
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDao dao = new ProductDao();
        ProductEntity product = new ProductEntity(name, price, quantity, 1);
        dao.insertProduct(product);
        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
    }
}
