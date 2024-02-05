package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.ResponseEntity.ResponseObject;
import edu.poly.duantotnghiep.dto.reponse.MauSacResponse;
import edu.poly.duantotnghiep.dto.request.MauSacRequest;
import edu.poly.duantotnghiep.service.IMauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mau-sac")
public class MauSacRestController {

//    @Autowired
//    private HttpServletRequest request;

    @Autowired
    private IMauSacService service;

    @GetMapping("find-all")
    public List<MauSacResponse> findAll() {
        return service.findAll();
    }

    //    @GetMapping("view-alll")
//    public String viewAdd(@ModelAttribute("mauSac") MauSacRequest mauSac){
//        request.setAttribute("method","add");
//        return "test";
//    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody MauSacRequest mauSac, BindingResult result) throws IOException {

        return new ResponseEntity<>(service.save(mauSac), HttpStatus.OK);
    }

//    @GetMapping("chiTiet/{ma}")
//    public ResponseEntity<MauSacDTOResponse> chiTiet(@PathVariable("ma") String ma){
//        return ResponseEntity.ok(service.findById(ma));
//    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable("id") String id) {
        Boolean exit = service.existsById(id);
        if (exit) {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ook", "Xóa thành công", ""));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(
                new ResponseObject("found", "Xóa thất bại", "")
        );
    }

    @PutMapping("update/{ma}")
    public ResponseEntity<?> update(@RequestBody MauSacRequest mausac, @PathVariable("ma") String ma) {

        return new ResponseEntity<>(service.update(mausac, ma), HttpStatus.OK);

    }

}
