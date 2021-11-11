package com.demo.servlet;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.entity.CategoryEntity;
import com.demo.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeProductServlet", urlPatterns = {"/homeproducts"})
public class HomeProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        List<CategoryEntity> categorys = dao.getAllCategory();
        request.setAttribute("categorys", categorys);
        ProductDao dao2 = new ProductDao();
        List<ProductEntity> products = dao2.getAllProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("homeproduct.jsp").forward(request, response);
    }
}
