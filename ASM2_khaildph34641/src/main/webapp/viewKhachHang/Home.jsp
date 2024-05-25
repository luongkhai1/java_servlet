<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center">Danh Sách Khách Hàng</h1>
<a href="/khachhang-Create" class="btn btn-info">Add</a>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Tên Khách Hàng</td>
        <td>Địa Chỉ</td>
        <td>Số Điện Thoại</td>
        <td>Trạng Thái</td>
        <td>Ngày Tạo</td>
        <td>Ngày Sửa</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listkhachhang}" var="kh" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${kh.id}</td>
            <td>${kh.hoTen}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.sdt}</td>
            <td>${kh.trangThai}</td>
            <td>${kh.ngayTao}</td>
            <td>${kh.ngaySua}</td>
            <td>
                <a href="/khachhang-Edit?id=${kh.id}" class="btn btn-warning">Edit</a>
                <a href="/khachhang-Delete?id=${kh.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>