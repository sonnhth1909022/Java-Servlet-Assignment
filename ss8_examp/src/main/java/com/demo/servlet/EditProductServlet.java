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

@WebServlet(name = "EditProductServlet",urlPatterns = "/admineditproduct")
public class EditProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        List<CategoryEntity> categoryEntities = dao.getAllCategory();
        request.setAttribute("categories", categoryEntities);
        int id = Integer.parseInt(request.getParameter("id"));
        ProductEntity existingUser = productDao.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editproduct.jsp");
        request.setAttribute("productes", existingUser);
        dispatcher.forward(request, response);
    }
}
