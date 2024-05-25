package com.example.asm2_khaildph34641.Controller;

import com.example.asm2_khaildph34641.model.mauSac;
import com.example.asm2_khaildph34641.repo.mauSacRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "MauSacServlet", value = {
        "/mausac-Create",
        "/mausac-Edit",
        "/mausac-List",
        "/mausac-Add",
        "/mausac-Update",
        "/mausac-Delete",
        "/mausac-Find"
})
public class MauSacServlet extends HttpServlet {
    mauSacRepo mauSacRepo = new mauSacRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/mausac-List")){
            this.list(request,response);
        } else if (uri.equals("/mausac-Create")) {
            this.create(request,response);
        } else if (uri.equals("/mausac-Edit")) {
            this.Edit(request,response);
        } else if (uri.equals("/mausac-Delete")) {
            this.delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mauSacRepo.Delete(id);
        response.sendRedirect("/mausac-List");
    }

    private void Edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("ms",mauSacRepo.Edit(id));
        request.setAttribute("page","/viewMauSac/Update.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page","/viewMauSac/Add.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mausac",mauSacRepo.getAll());
        request.setAttribute("page","/viewMauSac/Home.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/mausac-Add")){
            this.Add(request,response);
        } else if (uri.equals("/mausac-Update")) {
            this.update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        mauSacRepo.Update(getListUpdate(request,response));
        response.sendRedirect("/mausac-List");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        mauSacRepo.Add(getList(request,response));
        response.sendRedirect("/mausac-List");
    }

    public mauSac getList(HttpServletRequest request, HttpServletResponse response){
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaytao = new Date();
        mauSac mauSac = new mauSac(ma,ten,trangthai,null,ngaytao);
        return mauSac;
    }

    public mauSac getListUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangthai = request.getParameter("trangthai");
        Date ngaysua = new Date();
        mauSac mauSac = mauSacRepo.Edit(id);
        mauSac.setMaMau(ma);
        mauSac.setTenMau(ten);
        mauSac.setTrangThai(trangthai);
        mauSac.setNgaySua(ngaysua);
        return mauSac;
    }
}
