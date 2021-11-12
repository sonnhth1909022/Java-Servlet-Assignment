package com.demo.servlet;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet",urlPatterns = "/admindeletecategory")
public class DeleteCategoryServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDao.deleteCategory(id);
        response.sendRedirect("admincategory");
    }
}
