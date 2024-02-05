package edu.poly.duantotnghiep.dto.reponse;


import edu.poly.duantotnghiep.model.ChatLieuModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatLieuResponse {
    private String id;
    private String ten;
    private Date ngayTao;
    private Date ngayCapNhat;

    public ChatLieuResponse(ChatLieuModel model) {
        id = model.getId();
        ten = model.getTen();
        ngayTao = model.getNgayTao();
        ngayCapNhat = model.getNgayCapNhat();
    }

}
