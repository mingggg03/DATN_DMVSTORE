package edu.poly.duantotnghiep.service;



import edu.poly.duantotnghiep.dto.reponse.ThuongHieuDtoResponse;
import edu.poly.duantotnghiep.dto.request.ThuongHieuRequest;
import edu.poly.duantotnghiep.model.ThuongHieuModel;

import java.util.List;

public interface IThuongHieuService {
    public List<ThuongHieuDtoResponse> findAll();
    public ThuongHieuRequest save( ThuongHieuRequest thuongHieuRequest);
    public ThuongHieuModel findById(String s);
    public boolean existsById(String s);
    public void deleteById(String s);
    public void deleteByIds(List<String> s);
    ThuongHieuRequest update(ThuongHieuRequest thuongHieuRequest,String id);

    List<ThuongHieuDtoResponse> getThuongHieuBanChay();
}
