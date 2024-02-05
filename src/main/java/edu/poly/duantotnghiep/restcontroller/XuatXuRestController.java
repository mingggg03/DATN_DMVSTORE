package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.ResponseEntity.ResponseObject;
import edu.poly.duantotnghiep.dto.reponse.XuatXuResponse;
import edu.poly.duantotnghiep.dto.request.XuatXuRequest;
import edu.poly.duantotnghiep.service.IXuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xuat-xu")
public class XuatXuRestController {

    @Autowired
    private IXuatXuService service;

    @GetMapping("find-all")
    public List<XuatXuResponse> findAll(){
        return service.findAll();
    }

//    @GetMapping("chiTiet/{id}")
//    public ResponseEntity<XuatXuResponse> chiTiet(@PathVariable("id") String ma){
//        return ResponseEntity.ok(service.findById(ma));
//    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody XuatXuRequest xuatxu) {

        return new ResponseEntity<>(service.save(xuatxu),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable("id") String id){
        Boolean exit = service.existsById(id);
        if(exit){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ook","Xóa thành công",""));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(
                new ResponseObject("found", "Xóa thất bại", "")
        );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody XuatXuRequest xuatxu, @PathVariable("id") String id){

        return new ResponseEntity<>(service.update(xuatxu,id),HttpStatus.OK);
    }

}
