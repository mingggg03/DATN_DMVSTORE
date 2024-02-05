package edu.poly.duantotnghiep.repository;


import edu.poly.duantotnghiep.model.MauSacModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMauSacRepository extends JpaRepository<MauSacModel,String> {

    MauSacModel findMauSacModelByMa(String ma);

}
