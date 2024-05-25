<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2024
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center">Danh Sách Danh Mục</h1>
<a href="/danhmuc-Create" class="btn btn-info">Add</a>
<table class="table">
    <thead>
        <tr>
            <td>STT</td>
            <td>ID</td>
            <td>Mã Danh Mục</td>
            <td>Tên Danh Mục</td>
            <td>Trạng Thái</td>
            <td>Ngày Tạo</td>
            <td>Ngày Sửa</td>
            <td>Chức năng</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${danhmuc}" var="dm" varStatus="i">
            <tr>
                <td>${i.index +1}</td>
                <td>${dm.id}</td>
                <td>${dm.maDanhMuc}</td>
                <td>${dm.tenDanhMuc}</td>
                <td>${dm.trangThai}</td>
                <td>${dm.ngayTao}</td>
                <td>${dm.ngaySua}</td>
                <td>
                    <a href="/danhmuc-Edit?id=${dm.id}" class="btn btn-warning">Edit</a>
                    <a href="/danhmuc-Delete?id=${dm.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
