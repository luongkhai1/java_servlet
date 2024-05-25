<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/3/2024
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
    <h1 class="text-center">Danh Sách Hóa Đơn</h1>
    <thead>
        <tr>
            <td>STT</td>
            <td>Tên Khách Hàng</td>
            <td>Số Điện Thoại</td>
            <td>Ngày Tạo</td>
            <td>Địa Chỉ</td>
            <td>Trạng Thái</td>
            <td>
                Chức Năng
            </td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listhoadon}" var="hd" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hd.idKhachHang.hoTen}</td>
                <td>${hd.sdt}</td>
                <td>${hd.ngayTao}</td>
                <td>${hd.diaChi}</td>
                <td>${hd.trangThai}</td>
                <td>
                    <a href="/hoadon-details?" class="btn btn-primary">Chi Tiết</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>