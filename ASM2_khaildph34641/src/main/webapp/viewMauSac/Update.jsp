<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/mausac-Update" method="post">
    <div>
        <label>ID</label>
        <input type="text" name="id" class="form-control" readonly value="${ms.id}">
    </div>
    <div>
        <label>Mã màu</label>
        <input type="text" name="ma" class="form-control" value="${ms.maMau}">
    </div>
    <div>
        <label>Tên màu</label>
        <input type="text" name="ten" class="form-control" value="${ms.tenMau}">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active"
        <c:if test="${ms.trangThai == 'Active'}">checked</c:if>
        > Active
        <input type="radio" name="trangthai" value="InActive"
               <c:if test="${ms.trangThai == 'InActive'}">checked</c:if>
        > InActive
    </div>
    <button type="submit" class="btn btn-success">Sửa</button>
</form>
