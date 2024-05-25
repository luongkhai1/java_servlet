package com.example.asm2_khaildph34641.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "danh_muc")
public class danhMuc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;
    @Column(name = "ma_danh_muc")
    private String maDanhMuc;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;

    public danhMuc(String tenDanhMuc, String maDanhMuc, String trangThai, Date ngayTao, Date ngaySua) {
        this.tenDanhMuc = tenDanhMuc;
        this.maDanhMuc = maDanhMuc;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
}
