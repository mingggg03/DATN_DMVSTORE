package edu.poly.duantotnghiep.dto.reponse;


import edu.poly.duantotnghiep.model.MauSacModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MauSacResponse {
    private String ma;
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

    public MauSacResponse(MauSacModel model){
        ma = model.getMa();
        ten = model.getTen();
        ngayTao = model.getNgayTao();
        ngayCapNhat = model.getNgayCapNhat();

    }
}
