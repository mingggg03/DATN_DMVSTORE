package edu.poly.duantotnghiep.service.impl;


import edu.poly.duantotnghiep.dto.reponse.DongSanPhamResponese;
import edu.poly.duantotnghiep.dto.request.DongSanPhamRequest;
import edu.poly.duantotnghiep.model.DongSanPhamModel;
import edu.poly.duantotnghiep.model.ThuongHieuModel;
import edu.poly.duantotnghiep.repository.IDongSanPhamRepository;
import edu.poly.duantotnghiep.repository.IThuongHieuRepository;
import edu.poly.duantotnghiep.service.IDongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DongSanPhamServiceImpl implements IDongSanPhamService {
    @Autowired
    IDongSanPhamRepository repo;

    @Autowired
    IThuongHieuRepository repository;
    public List<DongSanPhamResponese> findAll() {
        return repo.findAll().stream()
                .map(d -> new DongSanPhamResponese(d))
                .collect(Collectors.toList());
    }


    public DongSanPhamRequest save(DongSanPhamRequest dongSanPhamDtoRequest) {
        DongSanPhamModel model  =  new DongSanPhamModel();

        model.setId(dongSanPhamDtoRequest.getId());
        model.setTen(dongSanPhamDtoRequest.getTen());
        ThuongHieuModel thuongHieuModel = repository.findThuongHieuModelById(dongSanPhamDtoRequest.getThuongHieu());
        model.setThuongHieu(thuongHieuModel);

        repo.save(model);


        return new DongSanPhamRequest(model);





    }

    public DongSanPhamModel findById(String s) {
    return repo.findDongSanPhamModelById(s);

    }

    @Override
    public DongSanPhamRequest update(DongSanPhamRequest dongSanPhamRequest, String id) {
        DongSanPhamModel model = repo.findDongSanPhamModelById(id);



        if(model != null){
            model.setId(id);
            ThuongHieuModel thuongHieuModel = repository.findThuongHieuModelById(dongSanPhamRequest.getThuongHieu());
            model.setThuongHieu(thuongHieuModel);
            model.setTen(dongSanPhamRequest.getTen());

            repo.save(model);
        }


        return new DongSanPhamRequest(model);
    }

    public boolean existsById(String s) {
        return repo.existsById(s);
    }

    public void deleteById(String s) {
        repo.deleteById(s);
    }

    @Override
    public void deleteByThuongHieu(String maTHuongHieu){
        ThuongHieuModel thuongHieuModel = new ThuongHieuModel();
        thuongHieuModel.setId(maTHuongHieu);
        repo.deleteByThuongHieu(thuongHieuModel);
    }

}
