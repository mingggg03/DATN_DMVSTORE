package edu.poly.duantotnghiep.repository;


import edu.poly.duantotnghiep.model.DongSanPhamModel;
import edu.poly.duantotnghiep.model.ThuongHieuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDongSanPhamRepository extends JpaRepository<DongSanPhamModel,String> {

    @Query(value = "SELECT * FROM dongsanpham WHERE id = ?1", nativeQuery = true)
    void deleteByThuongHieu(ThuongHieuModel  thuongHieuModel);
    DongSanPhamModel findDongSanPhamModelById(String id);
}
