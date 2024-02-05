package edu.poly.duantotnghiep.dto.request;


import edu.poly.duantotnghiep.model.DongSanPhamModel;
import edu.poly.duantotnghiep.model.ThuongHieuModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DongSanPhamRequest {
    private String id;
    @NotBlank(message = "Không được để trống tên!!")
    @Length(max = 100, message = "Tên tối đa 100 ký tự")
    private String ten;
    private String thuongHieu;
    private Date ngayTao;
    private Date ngayCapNhat;


public DongSanPhamRequest(DongSanPhamModel dongSanPhamModel) {
    if (dongSanPhamModel != null) {
        this.id = dongSanPhamModel.getId();

        this.ten = dongSanPhamModel.getTen();
        this.thuongHieu = dongSanPhamModel.getThuongHieu().getId();
        this.ngayTao = dongSanPhamModel.getNgayTao();
        this.ngayCapNhat = dongSanPhamModel.getNgayCapNhat();

    }
}
}
