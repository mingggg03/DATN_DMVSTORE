package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.ResponseEntity.ResponseObject;
import edu.poly.duantotnghiep.dto.request.DongSanPhamRequest;
import edu.poly.duantotnghiep.service.IDongSanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.io.IOException;

@RestController
@RequestMapping("/dong-san-pham")
public class DongSanPhamRestController {
//    @Autowired
//    private HttpServletRequest request;
    @Autowired
    private IDongSanPhamService service;

    @GetMapping("find-all")
    public ResponseEntity<?> findAll(){
        return  ResponseEntity.ok(service.findAll());
    }

//    @GetMapping("find-all")
//    public List<DongSanPhamResponese> findall(){
//        return service.findAll();
//    }




//    @GetMapping("chiTiet/{id}")
//    public ResponseEntity<DongSanPhamRequest> chiTiet(@PathVariable("id") String id){
//        return ResponseEntity.ok(service.findById(id));
//    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody DongSanPhamRequest dongSanPhamRequest) throws IOException {
    return new ResponseEntity<>(service.save(dongSanPhamRequest),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(
            @RequestBody DongSanPhamRequest dong, @PathVariable("id") String id
    ){


       return new ResponseEntity<>(service.update(dong,id),HttpStatus.OK);
    }


    @DeleteMapping("delete/{ma}")
    public ResponseEntity<ResponseObject> delete(@PathVariable("ma") String id){
        Boolean exit = service.existsById(id);
        if(exit){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ook","Xóa thành công",""));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(
                new ResponseObject("found", "Xóa thất bại", "")
        );
    }
}
