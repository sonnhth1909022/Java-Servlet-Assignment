package com.demo.servlet;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.entity.CategoryEntity;
import com.demo.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB

@WebServlet(name = "AddProductServlet", urlPatterns = {"/adminaddproduct"})
public class AddProductServlet extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    private static final String  SAVE_DIRECTORY  = "img";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Part filePart = request.getPart("image");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String RealPath = getServletContext().getRealPath("/")+"img\\"+fileName;
            File saveFile = new File(RealPath);
            filePart.write(saveFile+File.separator);

            int categoryid = Integer.parseInt(request.getParameter("category"));
            String description = request.getParameter("description");

            ProductDao dao = new ProductDao();
            ProductEntity product = new ProductEntity(name, price, quantity, fileName , categoryid, description);
            dao.insertProduct(product);
            response.sendRedirect("adminproducts");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        List<CategoryEntity> categoryEntities = dao.getAllCategory();
        request.setAttribute("categories", categoryEntities);
        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
    }

}

