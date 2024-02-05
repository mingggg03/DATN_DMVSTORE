package edu.poly.duantotnghiep.dto.request;

import edu.poly.duantotnghiep.model.SizeModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
@NotNull
public class SizeRequest {
    @NotNull(message = "Không để trống mã")
    @Max(value = 50, message = "Mã không quá 50 ")
    @Min(value = 20,message = "Mã tối thiểu 20")
    private Float ma;
    @NotNull(message = "Không để trống chiều dài")
    @Max(value = 70, message = "Chiều dài không quá 70 ")
    @Min(value = 20,message = "Chiều dài tối thiểu 20")
    private Float chieuDai;
    private Date ngayTao;
    private Date ngayCapNhat;

    public SizeRequest (SizeModel sizeModel){
        if(sizeModel != null){
            this.ma = sizeModel.getMa();
            this.chieuDai = sizeModel.getChieuDai();
            this.ngayTao = sizeModel.getNgayTao();
            this.ngayCapNhat = sizeModel.getNgayCapNhat();
        }
    }

}
