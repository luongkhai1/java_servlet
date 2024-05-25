<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/sanpham-Add" method="post">
    <div>
        <label>Mã Sản Phẩm</label>
        <input name="ma" type="text" class="form-control">
    </div>
    <div>
        <label>Tên Sản Phẩm</label>
        <input name="ten" type="text" class="form-control">
    </div>
    <div>
        <label>Danh Mục</label>
        <select name="danhmuc" class="form-control">
            <c:forEach items="${danhmuc}" var="dm" >
                <option value="${dm.id}">${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Trạng Thái</label><br>
        <input name="trangthai" type="radio" value="Active"> Active
        <input name="trangthai" type="radio" value="InActive"> InActive
    </div>
    <button class="btn btn-info" type="submit">Add</button>
</form>
