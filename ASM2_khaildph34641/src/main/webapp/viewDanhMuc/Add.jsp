<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2024
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/danhmuc-Add" method="post">
    <div>
        <label>Mã danh mục</label>
        <input type="text" name="ma" class="form-control">
    </div>
    <div>
        <label>Tên danh mục</label>
        <input type="text" name="ten" class="form-control">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active"> Active
        <input type="radio" name="trangthai" value="InActive"> InActive
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
