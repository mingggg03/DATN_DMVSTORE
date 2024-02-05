package edu.poly.duantotnghiep.dto.request;


import edu.poly.duantotnghiep.model.ChatLieuModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatLieuRequest {
    private String id;
    @NotBlank(message = "Không để trống tên")
    @Length(max = 100, message = "Tên tối đa 100 ký tự")
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

    public ChatLieuRequest (ChatLieuModel model){
        if(model != null){
            this.id = model.getId();
            this.ten = model.getTen();
            this.ngayTao = model.getNgayTao();
            this.ngayCapNhat = model.getNgayCapNhat();
        }
    }

}
