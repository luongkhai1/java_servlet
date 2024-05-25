<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center">Danh Sách Màu Sắc</h1>
<a href="/mausac-Create" class="btn btn-primary" >Add</a>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Mã Màu</td>
        <td>Tên Màu</td>
        <td>Trạng Thái</td>
        <td>Ngày Sửa</td>
        <td>Ngày Tạo</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mausac}" var="ms" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${ms.id}</td>
            <td>${ms.maMau}</td>
            <td>${ms.tenMau}</td>
            <td>${ms.trangThai}</td>
            <td>${ms.ngaySua}</td>
            <td>${ms.ngayTao}</td>
            <td>
                <a href="/mausac-Edit?id=${ms.id}" class="btn btn-warning">Edit</a>
                <a href="/mausac-Delete?id=${ms.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
