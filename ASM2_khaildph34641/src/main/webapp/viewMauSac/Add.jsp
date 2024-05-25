<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/mausac-Add" method="post">
    <div>
        <label>Mã màu</label>
        <input type="text" name="ma" class="form-control">
    </div>
    <div>
        <label>Tên màu</label>
        <input type="text" name="ten" class="form-control">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active"> Active
        <input type="radio" name="trangthai" value="InActive"> InActive
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
