package edu.poly.duantotnghiep.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVienModel {

    @Id
    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "vaitro")
    private VaiTroModel vaiTro;

    @Column(name = "password")
    private String password;

    @Column(name = "hovaten")
    private String hoVaTen;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "anhdaidien")
    private String anhDaiDien;

//    @OneToMany(mappedBy = "nhanVien")
//    @ToString.Exclude
//    private List<DonHangModel> donHangModels;
//
//    @PreRemove
//    private void preRemove(){
//        donHangModels.forEach(s -> s.setNhanVien(null));
//    }

//    @Transient
//    private Token token;
//
//    public Token getToken() {
//        TokenServiceImpl tokenService = new TokenServiceImpl();
//        return tokenService.getToken(username);
//    }
}
