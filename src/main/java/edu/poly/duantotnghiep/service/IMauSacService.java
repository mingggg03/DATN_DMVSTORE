package edu.poly.duantotnghiep.service;

import edu.poly.duantotnghiep.dto.reponse.MauSacResponse;
import edu.poly.duantotnghiep.dto.request.MauSacRequest;


import java.util.List;

public interface IMauSacService {
   List<MauSacResponse> findAll();
    public MauSacRequest save(MauSacRequest mauSacRequest);
    public MauSacRequest findById(String s);
    MauSacRequest update(MauSacRequest mauSacRequest, String ma);
    public boolean existsById(String s);
    public void deleteById(String s);
}
