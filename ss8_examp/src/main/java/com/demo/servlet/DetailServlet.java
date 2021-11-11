package com.demo.servlet;

import com.demo.dao.ProductDao;
import com.demo.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));

        ProductDao prodao = new ProductDao();
        ProductEntity p = prodao.getProductById(id);

        ProductDao prodaobycate = new ProductDao();
        List<ProductEntity> pc = prodaobycate.getLsProductByCategoryId(cid);

        request.setAttribute("detail", p);
        request.setAttribute("simdetail", pc);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
