package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.chiTietSanPham;
import com.example.asm2_khaildph34641.model.mauSac;
import com.example.asm2_khaildph34641.model.sanPham;
import com.example.asm2_khaildph34641.model.size;
import com.example.asm2_khaildph34641.repo.ChiTietSanPhamRepo;
import com.example.asm2_khaildph34641.repo.SanPhamRepo;
import com.example.asm2_khaildph34641.repo.mauSacRepo;
import com.example.asm2_khaildph34641.repo.sizeRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ChiTietSanPhamServlet", value = {
        "/chiitetsanpham-Create",
        "/chiitetsanpham-Edit",
        "/chiitetsanpham-List",
        "/chiitetsanpham-Add",
        "/chiitetsanpham-Update",
        "/chiitetsanpham-Delete",
        "/chiitetsanpham-Find"
})
public class ChiTietSanPhamServlet extends HttpServlet {

    ChiTietSanPhamRepo chiTietSanPhamRepo = new ChiTietSanPhamRepo();
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    mauSacRepo mauSacRepo = new mauSacRepo();
    sizeRepo sizeRePo = new sizeRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/chiitetsanpham-List")){
            this.list(request,response);
        } else if (uri.equals("/chiitetsanpham-Create")) {
            this.create(request,response);
        } else if (uri.equals("/chiitetsanpham-Edit")) {
            this.edit(request,response);
        } else if (uri.equals("/chiitetsanpham-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        chiTietSanPhamRepo.Delete(id);
        response.sendRedirect("/chiitetsanpham-List?idsp="+idsp);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idsp = Integer.parseInt((request.getParameter("idsp")));
        chiTietSanPham chiTietSanPham = chiTietSanPhamRepo.Findbyid(id);
        sanPham sanPham = sanPhamRepo.FindbyId(idsp);
        request.setAttribute("ms",mauSacRepo.Findbyid());
        request.setAttribute("sz",sizeRePo.Findbyid());
        request.setAttribute("sp",sanPham);
        request.setAttribute("ctsp",chiTietSanPham);
        request.setAttribute("page","/viewChiTietSanPham/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        request.setAttribute("ctsp",chiTietSanPhamRepo.Findbyid(idsp));
        request.setAttribute("sp",sanPhamRepo.FindbyId(idsp));
        request.setAttribute("ms",mauSacRepo.Findbyid());
        request.setAttribute("sz",sizeRePo.Findbyid());
        request.setAttribute("page","/viewChiTietSanPham/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        request.setAttribute("ctsp",chiTietSanPhamRepo.getAll(idsp));
        request.setAttribute("sp",sanPhamRepo.FindbyId(idsp));
        request.setAttribute("page","/viewChiTietSanPham/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/chiitetsanpham-Add")){
            this.add(request,response);
        } else if (uri.contains("/chiitetsanpham-Update")) {
            this.Update(request,response);
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        chiTietSanPhamRepo.Update(getlistUpdate(request,response));
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        response.sendRedirect("/chiitetsanpham-List?idsp="+idsp);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        chiTietSanPhamRepo.Add(getlist(request,response));
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        response.sendRedirect("/chiitetsanpham-List?idsp="+idsp);
    }

    public chiTietSanPham getlist(HttpServletRequest request, HttpServletResponse response) {
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        int tenmau = Integer.parseInt(request.getParameter("tenmau"));
        int tensize = Integer.parseInt(request.getParameter("tensize"));
        float giaban = Float.parseFloat(request.getParameter("giaban"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String trangthai = request.getParameter("trangthai");
        sanPham sanPham = sanPhamRepo.FindbyId(idsp);
        mauSac mauSac = mauSacRepo.Edit(tenmau);
        size size = sizeRePo.Edit(tensize);
        Date ngaytao = new Date();
        chiTietSanPham chiTietSanPham = new chiTietSanPham(sanPham,mauSac,size,giaban,soluong,trangthai,ngaytao,null);
        return chiTietSanPham;
    }

    public chiTietSanPham getlistUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int tenmau = Integer.parseInt(request.getParameter("tenmau"));
        int tensize = Integer.parseInt(request.getParameter("tensize"));
        float giaban = Float.parseFloat(request.getParameter("giaban"));
        int soluong = Integer.parseInt(request.getParameter("soluong"));
        String trangthai = request.getParameter("trangthai");
        chiTietSanPham chiTietSanPham = chiTietSanPhamRepo.Findbyid(id);
        mauSac mauSac = mauSacRepo.Edit(tenmau);
        size size = sizeRePo.Edit(tensize);
        Date ngaysua = new Date();
        chiTietSanPham.setIdMauSac(mauSac);
        chiTietSanPham.setIdSize(size);
        chiTietSanPham.setNgaySua(ngaysua);
        chiTietSanPham.setGiaBan(giaban);
        chiTietSanPham.setSoLuongTon(soluong);
        chiTietSanPham.setTrangThai(trangthai);
        return chiTietSanPham;
    }


}
