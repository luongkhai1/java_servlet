<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2024
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/chiitetsanpham-Create?idsp=${sp.id}" class="btn btn-info">Add</a>
<table class="table">
    <h1 class="text-center">Chi Tiết Sản Phẩm</h1>
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên Sản Phẩm</td>
        <td>Tên Tên Màu Sắc</td>
        <td>Tên Size</td>
        <td>Giá Bán</td>
        <td>Số Lượng Tồn</td>
        <td>Trạng Thái</td>
        <td>Ngày tạo</td>
        <td>Ngày Sửa</td>
        <td>Chức năng</td>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${ctsp}" var="ctsp" varStatus="i">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ctsp.idSanPham.tenSanPham}</td>
            <td>${ctsp.idMauSac.tenMau}</td>
            <td>${ctsp.idSize.tenSize}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.trangThai}</td>
            <td>${ctsp.ngayTao}</td>
            <td>${ctsp.ngaySua}</td>
            <td>
                <a href="/chiitetsanpham-Edit?id=${ctsp.id}&idsp=${sp.id}" class="btn btn-warning">Edit</a>
                <a href="/chiitetsanpham-Delete?id=${ctsp.id}&idsp=${sp.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
