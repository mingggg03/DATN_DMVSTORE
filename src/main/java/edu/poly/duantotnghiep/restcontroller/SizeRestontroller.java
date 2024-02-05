package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.dto.reponse.SizeDTOResponse;
import edu.poly.duantotnghiep.dto.request.SizeRequest;
import edu.poly.duantotnghiep.service.ISizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = "*")
public class SizeRestontroller {

//    @Autowired
//    private HttpServletRequest request;

//    @Autowired
//    private IChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private ISizeService service;

    @GetMapping("/find-all")
    public List<SizeDTOResponse> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SizeRequest size, BindingResult result) throws IOException {

        return new ResponseEntity<>(service.save(size), HttpStatus.OK);
    }

//    @GetMapping("/chi-tiet/{ma}")
//    public ResponseEntity<SizeDTOResponse> chiTiet(@PathVariable("ma") Float ma){
//        System.out.println(ma);
//        return ResponseEntity.ok(service.findById(ma));
//    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable Float ma) {

        service.deleteByMa(ma);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update/{ma}")
    public ResponseEntity<?> update(@Valid @RequestBody SizeRequest size,BindingResult result, @PathVariable Float ma) {

        return new ResponseEntity<>(service.update(size,ma),HttpStatus.OK);
    }
}
