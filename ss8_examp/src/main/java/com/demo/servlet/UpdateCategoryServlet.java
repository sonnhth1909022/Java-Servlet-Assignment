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

@WebServlet(name = "UpdateCategoryServlet",urlPatterns = "/adminupdatecategory")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        String name = request.getParameter("name");
        CategoryEntity productEntity =new CategoryEntity(name);
        dao.updateCategory(productEntity);
        response.sendRedirect("admincategory");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
