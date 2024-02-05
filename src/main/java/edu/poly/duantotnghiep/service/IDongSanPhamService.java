package edu.poly.duantotnghiep.service;



import edu.poly.duantotnghiep.dto.reponse.DongSanPhamResponese;
import edu.poly.duantotnghiep.dto.request.DongSanPhamRequest;
import edu.poly.duantotnghiep.model.DongSanPhamModel;

import java.util.List;

public interface IDongSanPhamService {
     List<DongSanPhamResponese> findAll();
     DongSanPhamRequest save(DongSanPhamRequest dongSanPhamDtoRequest);
 DongSanPhamModel findById(String s);
 DongSanPhamRequest update(DongSanPhamRequest dongSanPhamRequest, String id);
boolean existsById(String s);
 void deleteById(String s);

    void deleteByThuongHieu(String maTHuongHieu);
}
