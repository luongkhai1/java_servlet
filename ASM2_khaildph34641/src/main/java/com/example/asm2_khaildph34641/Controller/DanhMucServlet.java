package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.danhMuc;
import com.example.asm2_khaildph34641.repo.DanhMucRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "DanhMucServlet", value = {
        "/danhmuc-Create",
        "/danhmuc-Edit",
        "/danhmuc-List",
        "/danhmuc-Add",
        "/danhmuc-Update",
        "/danhmuc-Delete",
        "/danhmuc-Find"
})
public class DanhMucServlet extends HttpServlet {
    DanhMucRepo danhMucRepo = new DanhMucRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/danhmuc-List")){
            this.List(request,response);
        } else if (uri.equals("/danhmuc-Create")) {
            this.Create(request,response);
        } else if (uri.equals("/danhmuc-Edit")) {
            this.edit(request,response);
        } else if (uri.equals("/danhmuc-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        danhMucRepo.Delete(id);
        response.sendRedirect("/danhmuc-List");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("dm", danhMucRepo.FindbyId(id));
        request.setAttribute("page","/viewDanhMuc/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void Create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page","/viewDanhMuc/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void List(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhmuc",danhMucRepo.getAll());
        request.setAttribute("page","/viewDanhMuc/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/danhmuc-Add")){
            this.add(request,response);
        } else if (uri.equals("/danhmuc-Update")) {
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        danhMucRepo.Update(getListUpdate(request,response));
        response.sendRedirect("/danhmuc-List");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        danhMucRepo.add(getList(request,response));
        response.sendRedirect("/danhmuc-List");
    }

    public danhMuc getList(HttpServletRequest request, HttpServletResponse response){
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaytao = new Date();
        danhMuc danhMuc = new danhMuc(ma,ten,trangthai,ngaytao,null);
        return danhMuc;
    }
    public danhMuc getListUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaysua = new Date();
        danhMuc danhMuc = danhMucRepo.FindbyId(id);
        danhMuc.setMaDanhMuc(ma);
        danhMuc.setTenDanhMuc(ten);
        danhMuc.setTrangThai(trangthai);
        danhMuc.setNgaySua(ngaysua);
        return danhMuc;
    }
}
