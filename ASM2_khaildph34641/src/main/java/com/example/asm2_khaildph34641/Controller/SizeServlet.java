package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.size;
import com.example.asm2_khaildph34641.repo.sizeRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SizeServlet", value = {
        "/size-Create",
        "/size-Edit",
        "/size-List",
        "/size-Add",
        "/size-Update",
        "/size-Delete",
        "/size-Find"
})
public class SizeServlet extends HttpServlet {
    sizeRepo sizeRepo = new sizeRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/size-List")){
            this.list(request,response);
        } else if (uri.equals("/size-Create")) {
            this.Create(request,response);
        } else if (uri.equals("/size-Edit")) {
            this.edit(request,response);
        } else if (uri.equals("/size-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        sizeRepo.Delete(id);
        response.sendRedirect("/size-List");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("sz",sizeRepo.Edit(id));
        request.setAttribute("page","/viewSize/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void Create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page","/viewSize/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listsize",sizeRepo.getAll());
        request.setAttribute("page","/viewSize/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/size-Add")){
            this.add(request,response);
        } else if (uri.equals("/size-Update")) {
            this.Update(request,response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sizeRepo.Update(getlistUpdate(request,response));
        response.sendRedirect("/size-List");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sizeRepo.Add(getlist(request,response));
        response.sendRedirect("/size-List");
    }

    public size getlist(HttpServletRequest request, HttpServletResponse response) {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaytao = new Date();
        size size = new size(ma,ten,trangthai,null,ngaytao);
        return size;
    }

    public size getlistUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaysua = new Date();
        size size = sizeRepo.Edit(id);
        size.setMaSize(ma);
        size.setTenSize(ten);
        size.setTrangThai(trangthai);
        size.setNgaySua(ngaysua);
        return size;
    }
}
