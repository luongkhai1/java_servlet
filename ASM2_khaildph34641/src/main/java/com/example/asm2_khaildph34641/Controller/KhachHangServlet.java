package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.khachHang;
import com.example.asm2_khaildph34641.repo.khachHangRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", value = {
        "/khachhang-Create",
        "/khachhang-Edit",
        "/khachhang-List",
        "/khachhang-Add",
        "/khachhang-Update",
        "/khachhang-Delete",
        "/khachhang-Find"
})
public class KhachHangServlet extends HttpServlet {
    khachHangRepo khachHangRepo = new khachHangRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/khachhang-List")){
            this.list(request,response);
        } else if (uri.equals("/khachhang-Create")) {
            this.create(request,response);
        } else if (uri.equals("/khachhang-Edit")) {
            this.edit(request,response);
        } else if (uri.equals("/khachhang-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        khachHangRepo.Delete(id);
        response.sendRedirect("/khachhang-List");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("kh",khachHangRepo.edit(id));
        request.setAttribute("page","/viewKhachHang/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page","/viewKhachHang/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listkhachhang",khachHangRepo.getAll());
        request.setAttribute("page","/viewKhachHang/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/khachhang-Add")){
            this.add(request,response);
        } else if (uri.equals("/khachhang-Update")) {
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        khachHangRepo.Update(getListUpdate(request,response));
        response.sendRedirect("/khachhang-List");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        khachHangRepo.add(getList(request,response));
        response.sendRedirect("/khachhang-List");
    }

    public khachHang getList(HttpServletRequest request, HttpServletResponse response){
        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String trangthai = request.getParameter("trangthai");
        Date ngaytao = new Date();
        khachHang khachHang = new khachHang(ten,diachi,sdt,trangthai,ngaytao,null);
        return khachHang;
    }

    public khachHang getListUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        String trangthai = request.getParameter("trangthai");
        Date ngaysua = new Date();
        khachHang khachHang = khachHangRepo.edit(id);
        khachHang.setHoTen(ten);
        khachHang.setDiaChi(diachi);
        khachHang.setSdt(sdt);
        khachHang.setTrangThai(trangthai);
        khachHang.setNgaySua(ngaysua);
        return khachHang;
    }
}
