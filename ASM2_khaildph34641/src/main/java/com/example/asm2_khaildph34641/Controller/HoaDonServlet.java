package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.HDCT;
import com.example.asm2_khaildph34641.model.HoaDon;
import com.example.asm2_khaildph34641.model.khachHang;
import com.example.asm2_khaildph34641.repo.ChiTietSanPhamRepo;
import com.example.asm2_khaildph34641.repo.HoaDonChiTietRepo;
import com.example.asm2_khaildph34641.repo.HoaDonRepo;
import com.example.asm2_khaildph34641.repo.khachHangRepo;
import jakarta.persistence.GeneratedValue;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet(name = "HoaDonServlet", value = {
        "/hoadon-Create",
        "/hoadon-selectkh",
        "/hoadon-thanhtoan",
        "/hoadon-List",
        "/hoadon-Add",
        "/hoadon-Update",
        "/hoadon-Delete",
        "/hoadon-Find",
        "/dshoadon-List",
        "/hoadon-details"
})
public class HoaDonServlet extends HttpServlet {
    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    ChiTietSanPhamRepo chiTietSanPhamRepo = new ChiTietSanPhamRepo();
    khachHangRepo khachHangRepo = new khachHangRepo();
    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoadon-List")){
            this.list(request,response);
        } else if (uri.equals("/hoadon-selectkh")) {
            this.selectkh(request,response);
        } else if (uri.contains("/hoadon-Create")) {
            this.Create(request,response);
        } else if (uri.equals("/hoadon-thanhtoan")) {
            this.thanhtoan(request,response);
        } else if (uri.equals("/dshoadon-List")) {
            this.danhsach(request,response);
        } else if (uri.equals("/hoadon-Find")) {
            this.find(request,response);
        } else if (uri.equals("/hoadon-Delete")) {
            this.delete(request,response);
        } else if (uri.equals("/hoadon-details")) {
            this.details(request,response);
        }
    }

    private void details(HttpServletRequest request, HttpServletResponse response) {


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idhd = Integer.parseInt(request.getParameter("idhd"));
        hoaDonRepo.Delete(idhd);
        response.sendRedirect("/hoadon-List");
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String timkiem = request.getParameter("timkiem");
        request.setAttribute("listkhachhang",khachHangRepo.FindBynameorphone(timkiem));
        request.setAttribute("page","/viewHoaDon/TaoHoaDon.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void danhsach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listhoadon",hoaDonRepo.getAlll());
        request.setAttribute("page","/viewHoaDon/DanhSachHoaDon.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void thanhtoan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idhd = Integer.parseInt(request.getParameter("idhd"));
        HoaDon hoaDon = hoaDonRepo.find(idhd);
        hoaDon.setTrangThai("Paid");
        hoaDonRepo.Update(hoaDon);
        List<HDCT> list = hoaDonChiTietRepo.getAll(hoaDon);
        for (int i = 0; i < list.size(); i++) {
            HDCT hdct= list.get(i);
            hdct.setTrangThai("Paid");
            hoaDonChiTietRepo.Update(hdct);
        }
        response.sendRedirect("/hoadon-List");

    }

    private void Create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        khachHang khachHang1 = null;
        String idkh = request.getParameter("idkh");
        if (idkh == null || idkh.trim().isEmpty()){
            khachHang khachHang = new khachHang();
            khachHang.setHoTen(generateAutoCodeKH());
            khachHang.setDiaChi("Dia Chi");
            khachHang.setSdt(generateAutoCodeSDT());
            khachHang.setTrangThai("Active");
            khachHang.setNgayTao(new Date());
            khachHang.setNgaySua(new Date());
            khachHangRepo.add(khachHang);
            khachHang1 = khachHangRepo.find();
        }else {
            int idkh1 = Integer.parseInt(idkh);
            khachHang1 = khachHangRepo.edit(idkh1);
        }

        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKhachHang(khachHang1);
        hoaDon.setNgayTao(new Date());
        hoaDon.setSdt(khachHang1.getSdt());
        hoaDon.setDiaChi(khachHang1.getDiaChi());
        hoaDon.setTrangThai("UnPaid");
        hoaDon.setNgaySua(new Date());
        hoaDonRepo.add(hoaDon);
        response.sendRedirect("/hoadon-List");
    }

    private void selectkh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idkh = Integer.parseInt(request.getParameter("idkh"));
        khachHang khachHang = khachHangRepo.edit(idkh);
        request.setAttribute("kh",khachHang);
        request.setAttribute("listhoadon",hoaDonRepo.getAll());
        request.setAttribute("listkhachhang",khachHangRepo.getAll());
        request.setAttribute("page","/viewHoaDon/TaoHoaDon.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listhoadon",hoaDonRepo.getAll());
        request.setAttribute("listkhachhang",khachHangRepo.getAll());
        request.setAttribute("page","/viewHoaDon/TaoHoaDon.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String generateAutoCodeKH() {
        String uppercaseLetters = "KH";
        String numbers = "0123456789";

        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(uppercaseLetters);

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

    public String generateAutoCodeSDT() {
        String uppercaseLetters = "+84";
        String numbers = "0123456789";

        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(uppercaseLetters);

        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }
}
