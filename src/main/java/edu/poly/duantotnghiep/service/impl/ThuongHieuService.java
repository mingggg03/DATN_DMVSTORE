package edu.poly.duantotnghiep.service.impl;


import edu.poly.duantotnghiep.dto.reponse.ThuongHieuDtoResponse;
import edu.poly.duantotnghiep.dto.request.ThuongHieuRequest;
import edu.poly.duantotnghiep.model.ThuongHieuModel;
import edu.poly.duantotnghiep.repository.IThuongHieuRepository;
import edu.poly.duantotnghiep.service.IThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThuongHieuService implements IThuongHieuService {
    @Autowired
    private IThuongHieuRepository iThuongHieuRepository;
    @Override
    public List<ThuongHieuDtoResponse> findAll() {
        return iThuongHieuRepository.findAll().stream()
                .map(m-> new ThuongHieuDtoResponse(m))
                .collect(Collectors.toList());
    }

    @Override
    public ThuongHieuRequest save(ThuongHieuRequest thuongHieuRequest) {
        ThuongHieuModel model = new ThuongHieuModel();
        model.setId(thuongHieuRequest.getId());
        model.setTen(thuongHieuRequest.getTen());


        iThuongHieuRepository.save(model);

        return new ThuongHieuRequest(model);
    }

    @Override
    public ThuongHieuModel findById(String s) {
        return iThuongHieuRepository.findThuongHieuModelById(s);
    }

    @Override
    public boolean existsById(String s) {
        return iThuongHieuRepository.existsById(s);
    }

    @Override
    public void deleteById(String s) {
    iThuongHieuRepository.deleteById(s);
    }

    @Override
    public void deleteByIds(List<String> s) {
        for (String id : s){
            iThuongHieuRepository.deleteById(id);
        }
    }

    @Override
    public ThuongHieuRequest update(ThuongHieuRequest thuongHieuRequest, String id) {
        ThuongHieuModel model = iThuongHieuRepository.findThuongHieuModelById(id);
        if(model != null){
            model.setId(id);
            model.setTen(thuongHieuRequest.getTen());

            iThuongHieuRepository.save(model);
        }

        return new ThuongHieuRequest(model);
    }

    @Override
    public List<ThuongHieuDtoResponse> getThuongHieuBanChay(){
//        System.out.println("1111"+iThuongHieuRepository.getAllOrderByBanChay());
        return iThuongHieuRepository.getAllOrderByBanChay().stream().limit(4)
                .map(id -> new ThuongHieuDtoResponse(iThuongHieuRepository.findById(id).orElse(new ThuongHieuModel())))
                .collect(Collectors.toList());
    }



}
