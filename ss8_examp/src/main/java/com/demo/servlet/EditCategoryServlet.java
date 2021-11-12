package com.demo.servlet;

import com.demo.dao.CategoryDao;
import com.demo.entity.CategoryEntity;
import com.demo.entity.ProductEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCategoryServlet",urlPatterns = "/admineditcategory")
public class EditCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryEntity existingUser = categoryDao.getCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editcategory.jsp");
        request.setAttribute("categories", existingUser);
        dispatcher.forward(request, response);
    }
}
