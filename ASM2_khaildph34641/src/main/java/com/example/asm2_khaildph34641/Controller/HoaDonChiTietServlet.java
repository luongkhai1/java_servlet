package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.HDCT;
import com.example.asm2_khaildph34641.model.HoaDon;
import com.example.asm2_khaildph34641.model.chiTietSanPham;
import com.example.asm2_khaildph34641.repo.ChiTietSanPhamRepo;
import com.example.asm2_khaildph34641.repo.HoaDonChiTietRepo;
import com.example.asm2_khaildph34641.repo.HoaDonRepo;
import com.example.asm2_khaildph34641.repo.khachHangRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HoaDonChiTietServlet", value = {
        "/hoadonchitiet-chonmua",
        "/hoadonchitiet-thanhtoan",
        "/hoadonchitiet-List",
        "/hoadonchitiet-Add",
        "/hoadonchitiet-Update",
        "/hoadonchitiet-Delete",
        "/hoadonchitiet-Find",
        "/hoadon-Addsp"
})
public class HoaDonChiTietServlet extends HttpServlet {
    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    khachHangRepo khachHangRepo = new khachHangRepo();

    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();

    ChiTietSanPhamRepo chiTietSanPhamRepo = new ChiTietSanPhamRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/hoadon-Addsp")){
            this.create(request,response);
        } else if (uri.equals("/hoadonchitiet-chonmua")) {
            this.chonmua(request,response);
        } else if (uri.equals("/hoadonchitiet-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idhdct = Integer.parseInt(request.getParameter("idhdct"));
        int idhd = Integer.parseInt(request.getParameter("idhd"));
        HoaDon hoaDon = hoaDonRepo.find(idhd);
        request.setAttribute("hd",hoaDon);
        HDCT hdct = hoaDonChiTietRepo.edit(idhdct);
        chiTietSanPham chiTietSanPham = hdct.getIdCTSP();
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon()+hdct.getSoLuongMua());
        chiTietSanPhamRepo.Update(chiTietSanPham);
        hoaDonChiTietRepo.Delete(idhdct);
        response.sendRedirect("/hoadon-Addsp?idhd="+idhd);

    }

    private void chonmua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idhd= Integer.parseInt(request.getParameter("idhd"));
        HoaDon hoaDon = hoaDonRepo.find(idhd);
        request.setAttribute("hd",hoaDon);
        int index = -1;
        int idsp = Integer.parseInt(request.getParameter("idsp"));
        chiTietSanPham chiTietSanPham = chiTietSanPhamRepo.Findbyid(idsp);
        List<HDCT> chiTietSanPhamList = hoaDonChiTietRepo.getAll(hoaDon);
        for (int i = 0; i < chiTietSanPhamList.size(); i++) {
            if (idsp == chiTietSanPhamList.get(i).getIdCTSP().getId()){
                index = i;
                break;
            }
        }
        HDCT hdct = null;
        if (index == -1){
            hdct = new HDCT(hoaDon,chiTietSanPham,1, chiTietSanPham.getGiaBan(),chiTietSanPham.getGiaBan(),"UnPaid",new Date(),new Date());
            hoaDonChiTietRepo.add(hdct);
        }else {
            hdct = chiTietSanPhamList.get(index);
            hdct.setSoLuongMua(hdct.getSoLuongMua()+1);
            hdct.setTongTien(hdct.getSoLuongMua() * hdct.getGiaBan());
            hoaDonChiTietRepo.Update(hdct);
        }
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon()-1);
        chiTietSanPhamRepo.Update(chiTietSanPham);
        response.sendRedirect("/hoadon-Addsp?idhd="+idhd);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idhd= Integer.parseInt(request.getParameter("idhd"));
        HoaDon hoaDon = hoaDonRepo.find(idhd);
        request.setAttribute("hd",hoaDon);
        request.setAttribute("listhoadon",hoaDonRepo.getAll());
        request.setAttribute("listkhachhang",khachHangRepo.getAll());
        request.setAttribute("hdct",hoaDonChiTietRepo.getAll(hoaDon));
        request.setAttribute("ctsp",chiTietSanPhamRepo.getAll());
        request.setAttribute("TongTien",hoaDonChiTietRepo.getTongTien(idhd));
        request.setAttribute("page","/viewHoaDon/TaoHoaDon.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
