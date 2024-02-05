package edu.poly.duantotnghiep.service.impl;


import edu.poly.duantotnghiep.dto.reponse.MauSacResponse;
import edu.poly.duantotnghiep.dto.request.MauSacRequest;
import edu.poly.duantotnghiep.model.MauSacModel;
import edu.poly.duantotnghiep.repository.IMauSacRepository;
import edu.poly.duantotnghiep.service.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MauSacServiceImpl implements IMauSacService {
    @Autowired
    private IMauSacRepository mauSacRepository;


    public List<MauSacResponse> findAll() {
        return mauSacRepository.findAll().stream()
                .map(m -> new MauSacResponse(m))
                .collect(Collectors.toList());
    }

    public MauSacRequest save(MauSacRequest mauSacRequest) {
        MauSacModel model = new MauSacModel();


        model.setTen(model.getTen());

        mauSacRepository.save(model);

        return new MauSacRequest(model);
    }

    public MauSacRequest findById(String s) {
        MauSacModel model = mauSacRepository.findById(s).get();
        return new MauSacRequest(model);
    }

    @Override
    public MauSacRequest update(MauSacRequest mauSacRequest, String ma) {

        MauSacModel model = mauSacRepository.findMauSacModelByMa(ma);

        if(model != null){

            model.setMa(ma);
            model.setTen(mauSacRequest.getTen());

            mauSacRepository.save(model);
        }

        return new MauSacRequest(model);
    }

    public boolean existsById(String s) {
        return mauSacRepository.existsById(s);
    }

    public void deleteById(String s) {
        mauSacRepository.deleteById(s);
    }
}
