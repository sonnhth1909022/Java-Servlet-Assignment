package com.demo.servlet;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.entity.CategoryEntity;
import com.demo.entity.ProductEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProductServlet",urlPatterns = "/admindeleteproduct")
public class DeleteProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        productDao.deleteProduct(id);
        response.sendRedirect("adminproducts");
    }
}
