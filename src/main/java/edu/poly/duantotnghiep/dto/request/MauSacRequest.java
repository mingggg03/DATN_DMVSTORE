package edu.poly.duantotnghiep.dto.request;


import edu.poly.duantotnghiep.model.MauSacModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MauSacRequest {
    private String ma;
    @NotBlank(message = "Không được để trống tên!!!")
    @Length(max = 100, message = "Tên tối đa 100 ký tự")
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

    public MauSacRequest (MauSacModel mauSacModel){

        if(mauSacModel != null){
            this.ma = mauSacModel.getMa();
            this.ten = mauSacModel.getTen();
            this.ngayTao = mauSacModel.getNgayTao();
            this.ngayCapNhat = mauSacModel.getNgayCapNhat();
        }

    }
}
