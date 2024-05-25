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
@Table(name = "ctsp")
public class chiTietSanPham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private sanPham idSanPham;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private mauSac idMauSac;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private size idSize;
    @Column(name = "gia_ban")
    private float giaBan;
    @Column(name = "so_luong_ton")
    private int soLuongTon;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;

    public chiTietSanPham(sanPham idSanPham, mauSac idMauSac, size idSize, float giaBan, int soLuongTon, String trangThai, Date ngayTao, Date ngaySua) {
        this.idSanPham = idSanPham;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }
}
