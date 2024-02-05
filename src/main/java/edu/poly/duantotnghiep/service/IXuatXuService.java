package edu.poly.duantotnghiep.service;



import edu.poly.duantotnghiep.dto.reponse.XuatXuResponse;
import edu.poly.duantotnghiep.dto.request.XuatXuRequest;
import edu.poly.duantotnghiep.model.XuatXuModel;

import java.util.List;

public interface IXuatXuService {
    List<XuatXuResponse> findAll();
    XuatXuRequest save(XuatXuRequest request);
    XuatXuModel findById(String s);
    XuatXuRequest update(XuatXuRequest xuatXuRequest, String s);
    void deleteByMa(String s);
    boolean existsById(String s);
    void deleteById(String s);
}
