package edu.poly.duantotnghiep.dto.reponse;


import edu.poly.duantotnghiep.model.XuatXuModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class XuatXuResponse {
    private String id;
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

    public XuatXuResponse(XuatXuModel model){
        id = model.getId();
        ten = model.getTen();
        ngayTao = model.getNgayTao();
        ngayCapNhat = model.getNgayCapNhat();

    }
}
