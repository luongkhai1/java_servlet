<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/khachhang-Update" method="post">
    <div>
        <label>ID</label>
        <input type="text" name="id" class="form-control" value="${kh.id}" readonly>
    </div>
    <div>
        <label>Tên Khách Hàng</label>
        <input type="text" name="ten" class="form-control" value="${kh.hoTen}">
    </div>
    <div>
        <label>Địa Chỉ</label>
        <input type="text" name="diachi" class="form-control" value="${kh.diaChi}">
    </div>
    <div>
        <label>Số điện thoại</label>
        <input type="text" name="sdt" class="form-control" value="${kh.sdt}">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active" readonly
               <c:if test="${kh.trangThai == 'Active'}">checked</c:if>
        > Active
        <input type="radio" name="trangthai" value="InActive"
               <c:if test="${kh.trangThai == 'InActive'}">checked</c:if>
        > InActive
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
