package edu.poly.duantotnghiep.service.impl;

import edu.poly.duantotnghiep.dto.reponse.SizeDTOResponse;
import edu.poly.duantotnghiep.dto.request.SizeRequest;
import edu.poly.duantotnghiep.model.SizeModel;
import edu.poly.duantotnghiep.repository.ISizeRepository;
import edu.poly.duantotnghiep.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository repo;

    @Override
    public List<SizeDTOResponse> findAll() {
        return repo.findAll().stream()
                .map(m -> new SizeDTOResponse(m))
                .collect(Collectors.toList());
    }

    @Override
    public SizeRequest save(SizeRequest sizeRequest) {
        SizeModel model = new SizeModel();
        model.setMa(sizeRequest.getMa());
        model.setChieuDai(sizeRequest.getChieuDai());

        repo.save(model);
        return new SizeRequest(model);
    }

    @Override
    public SizeModel findById(Float ma) {
        return repo.findSizeModelByMa(ma);
    }

    @Override
    public boolean existById(Float ma) {
        return false;
    }

    @Override
    public void deleteByMa(Float ma) {
        repo.deleteById(ma);

    }


    @Override
    public SizeRequest update(SizeRequest sizeRequest, Float ma) {
        SizeModel model = repo.findSizeModelByMa(ma);
        if(model != null){
            model.setMa(ma);
            model.setChieuDai(sizeRequest.getChieuDai());
            repo.save(model);
        }


        return new SizeRequest(model);
    }
}
