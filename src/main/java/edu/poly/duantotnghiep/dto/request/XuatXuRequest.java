package edu.poly.duantotnghiep.dto.request;


import edu.poly.duantotnghiep.model.XuatXuModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NotNull
public class XuatXuRequest {
    private String id;
    @NotBlank(message = "Không được để trống tên!!!")
    @Length(max = 100, message = "Tên tối đa 100 ký tự")
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

//    public XuatXuModel mapXuatXuToModel(){
//        XuatXuModel model = new XuatXuModel();
//        model.setId(id);
//        model.setTen(ten);
//        model.setNgayTao(ngayTao);
//        model.setNgayCapNhat(ngayCapNhat);
//        return model;
//    }

    public XuatXuRequest (XuatXuModel model){
        if(model != null){
            this.id = model.getId();
            this.ten = model.getTen();
            this.ngayTao = model.getNgayTao();
            this.ngayCapNhat = model.getNgayCapNhat();
        }
    }
}
