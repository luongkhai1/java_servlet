package com.example.asm2_khaildph34641.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hdct")
public class HDCT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon idHoaDon;
    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private chiTietSanPham idCTSP;
    @Column(name = "so_luong_mua")
    private int soLuongMua;
    @Column(name = "gia_ban")
    private float giaBan;
    @Column(name = "tong_tien")
    private float tongTien;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;

    public HDCT(HoaDon idHoaDon, chiTietSanPham idCTSP, int soLuongMua, float giaBan, float tongTien, String trangThai, Date ngayTao, Date ngaySua) {
        this.idHoaDon = idHoaDon;
        this.idCTSP = idCTSP;
        this.soLuongMua = soLuongMua;
        this.giaBan = giaBan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
}
