package com.demo.servlet;

import com.demo.dao.ProductDao;
import com.demo.entity.ProductEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(name = "UpdateProductServlet",urlPatterns = "/adminupdateproduct")
public class UpdateProductServlet extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    private static final String  SAVE_DIRECTORY  = "img";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao dao = new ProductDao();
            ProductEntity productEntity = new ProductEntity();
            /*int id = Integer.parseInt(request.getParameter("id"));*/
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int category = Integer.parseInt(request.getParameter("category"));
           /* productEntity.setId(id);*/
            productEntity.setName( name);
            productEntity.setPrice( price);
            productEntity.setQuantity(quantity);
            productEntity.setCategoryid(category);
          /*  Part filePart = request.getPart("image");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String RealPath = getServletContext().getRealPath("/")+"img\\"+fileName;
            File saveFile = new File(RealPath);
            filePart.write(saveFile+File.separator);*/
           /* productEntity.setCategoryid(Integer.parseInt(request.getParameter("category")));*/

           dao.updateProduct(productEntity);
               response.sendRedirect("adminproducts");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.getRequestDispatcher("product.jsp").forward(request, response);*/
    }
}
