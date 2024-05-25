<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/sanpham-Create" class="btn btn-primary">Add</a>
<h1 class="text-center">Danh Sách Sản Phẩm</h1>
<table class="table">
    <thead>
        <tr>
            <td>STT</td>
            <td>ID</td>
            <td>Mã sản phẩm</td>
            <td>Tên sản phẩm</td>
            <td>Trạng thái</td>
            <td>Danh Mục</td>
            <td>Ngày tạo</td>
            <td>Ngày Sửa</td>
            <td>Chức năng</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listsanpham}" var="sp" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${sp.id}</td>
                <td>${sp.maSanPham}</td>
                <td>${sp.tenSanPham}</td>
                <td>${sp.trangThai}</td>
                <td>${sp.idDanhMuc.tenDanhMuc}</td>
                <td>${sp.ngayTao}</td>
                <td>${sp.ngaySua}</td>
                <td>
                    <a href="/chiitetsanpham-List?idsp=${sp.id}" class="btn btn-primary">Chi Tiết</a>
                    <a href="/sanpham-Edit?id=${sp.id}" class="btn btn-warning">Edit</a>
                    <a href="/sanpham-Delete?id=${sp.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

