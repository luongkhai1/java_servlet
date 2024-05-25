package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.danhMuc;
import com.example.asm2_khaildph34641.model.sanPham;
import com.example.asm2_khaildph34641.repo.DanhMucRepo;
import com.example.asm2_khaildph34641.repo.SanPhamRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SanPhamServlet", value = {
        "/sanpham-Create",
        "/sanpham-Edit",
        "/sanpham-List",
        "/sanpham-Add",
        "/sanpham-Update",
        "/sanpham-Delete",
        "/sanpham-Find"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    DanhMucRepo danhMucRepo = new DanhMucRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sanpham-List")){
            this.ListSP(request,response);
        }else if (uri.equals("/sanpham-Create")){
            this.Create(request,response);
        } else if (uri.equals("/sanpham-Delete")) {
            this.delete(request,response);
        } else if (uri.equals("/sanpham-Edit")) {
            this.edit(request,response);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("danhmuc",danhMucRepo.getAll());
        request.setAttribute("sp",sanPhamRepo.FindbyId(id));
        request.setAttribute("page","/viewSanPham/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        sanPhamRepo.Delete(id);
        response.sendRedirect("/sanpham-List");
    }

    private void Create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhmuc",danhMucRepo.getAll());
        request.setAttribute("page","/viewSanPham/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void ListSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listsanpham",sanPhamRepo.getAll());
        request.setAttribute("page","/viewSanPham/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sanpham-Add")){
            this.add(request,response);
        } else if (uri.equals("/sanpham-Update")) {
            this.Update(request,response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sanPhamRepo.Update(getListUpdate(request,response));
        response.sendRedirect("/sanpham-List");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sanPhamRepo.Add(getList(request,response));
        response.sendRedirect("/sanpham-List");
    }

    public sanPham getList(HttpServletRequest request, HttpServletResponse response){
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int iddanhmuc = Integer.parseInt(request.getParameter("danhmuc"));
        danhMuc danhMuc = danhMucRepo.FindbyId(iddanhmuc);
        String trangthai = request.getParameter("trangthai");
        Date ngaytao = new Date();
        sanPham sanPham = new sanPham(ma,ten,trangthai,ngaytao,null,danhMuc);
        return sanPham;
    }

    public sanPham getListUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int iddanhmuc = Integer.parseInt(request.getParameter("danhmuc"));
        danhMuc danhMuc = danhMucRepo.FindbyId(iddanhmuc);
        String trangthai = request.getParameter("trangthai");
        Date ngaysua = new Date();
        sanPham sanPham = sanPhamRepo.FindbyId(id);
        sanPham.setMaSanPham(ma);
        sanPham.setTenSanPham(ten);
        sanPham.setIdDanhMuc(danhMuc);
        sanPham.setTrangThai(trangthai);
        sanPham.setNgaySua(ngaysua);
        return sanPham;
    }

}
