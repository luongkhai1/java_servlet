<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<form action="/sanpham-Update" method="post">
    <div>
        <label>ID</label>
        <input name="id" class="form-control" readonly value="${sp.id}">
    </div>
    <div>
        <label>Mã Sản Phẩm</label>
        <input name="ma" type="text" class="form-control" value="${sp.maSanPham}">
    </div>
    <div>
        <label>Tên Sản Phẩm</label>
        <input name="ten" type="text" class="form-control" value="${sp.tenSanPham}">
    </div>
    <div>
        <label>Danh Mục</label>
        <select name="danhmuc" class="form-control">
            <c:forEach items="${danhmuc}" var="dm" >
                <option value="${dm.id}"
                        <c:if test="${sp.idDanhMuc.id == dm.id}">selected</c:if>
                >${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label>Trạng Thái</label><br>
        <input name="trangthai" type="radio" value="Đang bán"
        <c:if test="${sp.trangThai == 'Active'}">checked</c:if>
        > Active
        <input name="trangthai" type="radio" value="Hết Hàng"
        <c:if test="${sp.trangThai == 'InActive'}">checked</c:if>
        > InActive
    </div>
    <button class="btn btn-info" type="submit">Update</button>
</form>

