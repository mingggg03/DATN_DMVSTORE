package edu.poly.duantotnghiep.dto.request;


import edu.poly.duantotnghiep.model.ThuongHieuModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ThuongHieuRequest {
    private String id;
    @NotBlank(message = "Không được để trống tên!!!")
    @Length(max = 100, message = "Tên tối đa 100 ký tự")
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;



    public ThuongHieuRequest (ThuongHieuModel thuongHieuModel){
        if(thuongHieuModel != null){
            this.id = thuongHieuModel.getId();
            this.ten = thuongHieuModel.getTen();
            this.ngayTao = thuongHieuModel.getNgayTao();
            this.ngayCapNhat = thuongHieuModel.getNgayCapNhat();

        }
    }
}
