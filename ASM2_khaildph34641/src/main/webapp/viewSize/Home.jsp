<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/size-Create" class="btn btn-primary">Add</a>
<h1 class="text-center">Danh Sách Size</h1>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Mã Size</td>
        <td>Tên Size</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày Sửa</td>
        <td>Chức năng</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listsize}" var="sz" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${sz.id}</td>
            <td>${sz.maSize}</td>
            <td>${sz.tenSize}</td>
            <td>${sz.trangThai}</td>
            <td>${sz.ngayTao}</td>
            <td>${sz.ngaySua}</td>
            <td>
                <a href="/size-Edit?id=${sz.id}" class="btn btn-warning">Edit</a>
                <a href="/size-Delete?id=${sz.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
