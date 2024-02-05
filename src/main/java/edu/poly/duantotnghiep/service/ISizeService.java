package edu.poly.duantotnghiep.service;

import edu.poly.duantotnghiep.dto.reponse.SizeDTOResponse;
import edu.poly.duantotnghiep.dto.request.SizeRequest;
import edu.poly.duantotnghiep.model.SizeModel;

import java.util.List;

public interface ISizeService {
    List<SizeDTOResponse> findAll();

    SizeRequest save(SizeRequest sizeRequest);

    SizeModel findById(Float ma);

    public boolean existById(Float ma);

    void deleteByMa(Float ma);

    SizeRequest update(SizeRequest sizeRequest, Float ma);


}
