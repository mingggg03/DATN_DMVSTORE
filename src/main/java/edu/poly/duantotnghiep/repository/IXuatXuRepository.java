package edu.poly.duantotnghiep.repository;


import edu.poly.duantotnghiep.model.XuatXuModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IXuatXuRepository extends JpaRepository<XuatXuModel,String> {

    XuatXuModel findXuatXuModelById(String id);

}
