package edu.poly.duantotnghiep.restcontroller;


import edu.poly.duantotnghiep.dto.reponse.ChatLieuResponse;
import edu.poly.duantotnghiep.dto.request.ChatLieuRequest;
import edu.poly.duantotnghiep.service.IChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/chat-lieu")
public class ChatLieuRestController {
//    @Autowired
//    private HttpServletRequest request;

    @Autowired
    private IChatLieuService service;

    @GetMapping("find-all")
    public List<ChatLieuResponse> findAll() {
        return service.findAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody ChatLieuRequest chatLieu, BindingResult result) throws IOException {
       return new ResponseEntity<>(service.save(chatLieu), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ChatLieuRequest chatLieu, @PathVariable String id) {
        return new ResponseEntity<>(service.update(chatLieu,id), HttpStatus.OK);
    }
//    @GetMapping("/chi-tiet/{id}")
//    public ResponseEntity<ChatLieuDTOResponse> chiTiet(@PathVariable("id") String id){
//        System.out.println(id);
//        return ResponseEntity.ok(service.findById(id));
//    }
}
