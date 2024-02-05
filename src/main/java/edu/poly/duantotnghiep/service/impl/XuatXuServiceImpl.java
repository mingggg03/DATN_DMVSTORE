package edu.poly.duantotnghiep.service.impl;


import edu.poly.duantotnghiep.dto.reponse.XuatXuResponse;
import edu.poly.duantotnghiep.dto.request.XuatXuRequest;
import edu.poly.duantotnghiep.model.XuatXuModel;
import edu.poly.duantotnghiep.repository.IXuatXuRepository;
import edu.poly.duantotnghiep.service.IXuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class XuatXuServiceImpl implements IXuatXuService {
    @Autowired
    private IXuatXuRepository repo;
@Override
    public List<XuatXuResponse> findAll() {
        return repo.findAll().stream()
                .map(x -> new XuatXuResponse(x))
                .collect(Collectors.toList());
    }
    @Override
    public XuatXuRequest save(XuatXuRequest request){
        XuatXuModel model = new XuatXuModel();
        model.setId(request.getId());
        model.setTen(request.getTen());

        repo.save(model);

        return new XuatXuRequest(model);
    }

    @Override
    public XuatXuModel findById(String s) {
        return repo.findXuatXuModelById(s);
    }

    @Override
    public XuatXuRequest update(XuatXuRequest xuatXuRequest, String s) {
    XuatXuModel model = repo.findXuatXuModelById(s);

    if(model != null){
        model.setTen(s);
        model.setTen(xuatXuRequest.getTen());
        repo.save(model);
    }

    return new XuatXuRequest(model);
    }

    @Override
    public void deleteByMa(String s) {
        repo.deleteById(s);
    }


    public boolean existsById(String s) {
        return repo.existsById(s);
    }

    public void deleteById(String s) {
        repo.deleteById(s);
    }
}
