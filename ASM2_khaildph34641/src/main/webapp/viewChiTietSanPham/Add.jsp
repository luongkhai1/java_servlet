<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2024
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/chiitetsanpham-Add?idsp=${sp.id}" method="post">
    <div>
        <label>Tên Sản phẩm</label>
        <input type="text" name="tensp" class="form-control" value="${sp.tenSanPham}" readonly>
    </div>
    <div>
        <label>Tên Màu Sắc</label>
        <select name="tenmau" class="form-control">
            <c:forEach items="${ms}" var="ms">
                <option value="${ms.id}" >${ms.tenMau}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Tên Size</label>
        <select name="tensize" class="form-control">
            <c:forEach items="${sz}" var="sz">
                <option value="${sz.id}" >${sz.tenSize}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Giá bán</label>
        <input type="text" name="giaban" class="form-control">
    </div>
    <div>
        <label>Số Lượng</label>
        <input type="text" name="soluong" class="form-control">
    </div>
    <div>
        <label>Trạng thái</label><br>
        <input type="radio" name="trangthai" value="Active"> Active
        <input type="radio" name="trangthai" value="InActive"> InActive
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
