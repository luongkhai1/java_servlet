<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2024
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/danhmuc-Update" method="post">
    <div>
        <label>ID</label>
        <input type="text" name="id" class="form-control" value="${dm.id}" readonly>
    </div>
    <div>
        <label>Mã danh mục</label>
        <input type="text" name="ma" class="form-control" value="${dm.maDanhMuc}">
    </div>
    <div>
        <label>Tên danh mục</label>
        <input type="text" name="ten" class="form-control" value="${dm.tenDanhMuc}">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active" readonly
                <c:if test="${dm.trangThai == 'Active'}">checked</c:if>
        > Active
        <input type="radio" name="trangthai" value="InActive"
               <c:if test="${dm.trangThai == 'InActive'}">checked</c:if>
        > InActive
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>