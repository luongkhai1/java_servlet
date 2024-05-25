<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/3/2024
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-7">
        <h1 class="text-center">Danh Sách Hóa Đơn</h1>
        <a href="/hoadon-Create?idkh=${kh.id}" class="btn btn-primary">Tạo Hóa Đơn</a>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Tên Khách Hàng</td>
                <td>Địa Chỉ</td>
                <td>SDT</td>
                <td>Trạng Thái</td>
                <td>Chức năng</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listhoadon}" var="hd" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${hd.id}</td>
                    <td>${hd.idKhachHang.hoTen}</td>
                    <td>${hd.diaChi}</td>
                    <td>${hd.sdt}</td>
                    <td>${hd.trangThai}</td>
                    <td>
                        <a href="/hoadon-Delete?idhd=${hd.id}" class="btn btn-danger"> Xóa</a>
                        <a href="/hoadon-Addsp?idhd=${hd.id}" class="btn btn-primary">Chọn</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h1 class="text-center">Danh Sách Khách Hàng</h1>
        <form action="/hoadon-Find" method="get">
            <label>Tìm Kiếm</label>
            <input type="text" name="timkiem" class="form-control" placeholder="Tìm kiếm theo tên hoặc số điện thoại">
            <button type="submit" class="btn btn-success">Search</button>
        </form>
        <table class="table">
            <thead>
                <tr>
                    <td>STT</td>
                    <td>ID</td>
                    <td>Tên Khách Hàng</td>
                    <td>Địa Chỉ</td>
                    <td>Số Điện Thoại</td>
                    <td>Chức năng</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listkhachhang}" var="kh" varStatus="i">
                <tr>
                    <td>${i.index +1}</td>
                    <td>${kh.id}</td>
                    <td>${kh.hoTen}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.sdt}</td>
                    <td>
                        <a href="/hoadon-selectkh?idkh=${kh.id}" class="btn btn-danger">Chọn</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <h1 class="text-center">Danh Sách Sản Phẩm</h1>
    <table class="table">
        <thead>
        <tr>
            <td>ID</td>
            <td>Tên Sản Phẩm</td>
            <td>Tên Tên Màu Sắc</td>
            <td>Tên Size</td>
            <td>Giá Bán</td>
            <td>Số Lượng Tồn</td>
            <td>Trạng Thái</td>
            <td>Chức năng</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ctsp}" var="ctsp" varStatus="i">
            <tr>
                <td>${ctsp.id}</td>
                <td>${ctsp.idSanPham.tenSanPham}</td>
                <td>${ctsp.idMauSac.tenMau}</td>
                <td>${ctsp.idSize.tenSize}</td>
                <td>${ctsp.giaBan}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.trangThai}</td>
                <td>
                    <a href="/hoadonchitiet-chonmua?idhd=${hd.id}&idsp=${ctsp.id}" class="btn btn-warning">Chọn Mua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="row">
    <h1 class="text-center">Hóa Đơn Chi Tiết</h1>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID</td>
            <td>Tên Sản Phẩm</td>
            <td>Số Lượng</td>
            <td>Giá Bán</td>
            <td>Tổng Tiền</td>
            <td>Chức năng</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${hdct}" var="hdct" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hdct.id}</td>
                <td>${hdct.idCTSP.idSanPham.tenSanPham}</td>
                <td>${hdct.soLuongMua}</td>
                <td>${hdct.giaBan}</td>
                <td>${hdct.tongTien}</td>
                <td>
                    <a href="/hoadonchitiet-Delete?idhdct=${hdct.id}&idhd=${hd.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">Tổng Tiền</td>
            <td colspan="3">${TongTien}</td>
            <td>
                <a href="/hoadon-thanhtoan?idhd=${hd.id}" class="btn btn-info">Thanh Toán</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>