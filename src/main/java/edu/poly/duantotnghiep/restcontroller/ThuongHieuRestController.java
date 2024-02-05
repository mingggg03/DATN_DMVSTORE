package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.dto.request.ThuongHieuRequest;
import edu.poly.duantotnghiep.service.IDongSanPhamService;
import edu.poly.duantotnghiep.service.IThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thuong-hieu")
public class ThuongHieuRestController {
//    @Autowired
//    private HttpServletRequest request;
    @Autowired
    private IThuongHieuService service;
    @Autowired
    private IDongSanPhamService dongSanPhamService;
    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());

    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ThuongHieuRequest thuonghieu ){
        return new ResponseEntity<>(service.save(thuonghieu),HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody ThuongHieuRequest thuonghieu, @PathVariable("id") String id){
    return new ResponseEntity<>(service.update(thuonghieu,id),HttpStatus.OK);
    }
    @DeleteMapping("deletes")
    public ResponseEntity<?> deletes(@RequestBody List<String> id){
        id.forEach(idTH -> dongSanPhamService.deleteByThuongHieu(idTH));
        service.deleteByIds(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
//    @GetMapping("/{id}")
//    public ThuongHieuDtoResponse findById(@PathVariable("id") String id){
//        return service.findById(id);
//    }

}
