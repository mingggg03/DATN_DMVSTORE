package edu.poly.duantotnghiep.controller;



import edu.poly.duantotnghiep.dto.reponse.DongSanPhamResponese;
import edu.poly.duantotnghiep.dto.request.DongSanPhamRequest;
import edu.poly.duantotnghiep.model.DongSanPhamModel;
import edu.poly.duantotnghiep.service.IDongSanPhamService;
import edu.poly.duantotnghiep.service.IThuongHieuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("${admin.domain}/dong-san-pham")
public class DongSanPhamController {

    private final IDongSanPhamService iDongSanPhamService;

    private final IThuongHieuService iThuongHieuService;
    @GetMapping("")
    public String showAll(Model model){

        model.addAttribute("thuongHieu", iThuongHieuService.findAll());

        model.addAttribute("dongsp1", new DongSanPhamRequest());

        List<DongSanPhamResponese> results = iDongSanPhamService.findAll();

        model.addAttribute("dongsp", results);

        return "admin/dongSanPham";
    }
//    @GetMapping("/add")
//    public String formAdd(Model model) {
//
//
//        return "DongSp/dongSanPham";
//    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") String id, Model model){
        DongSanPhamModel dongSanPhamModel = iDongSanPhamService.findById(id);
        DongSanPhamRequest dongSanPhamRequest = new DongSanPhamRequest(dongSanPhamModel);
        model.addAttribute("action","/update/"+id);
        model.addAttribute("dongsp1", dongSanPhamRequest);

        return "DongSp/dongSanPham";


    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("dongsp1")DongSanPhamRequest dongSanPhamRequest, BindingResult result){

        if (result.hasErrors()){

        }
        iDongSanPhamService.save(dongSanPhamRequest);

        return "redirect:/dong-san-pham";


    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {

        iDongSanPhamService.deleteById(id);

        return "redirect:/dong-san-pham";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,@ModelAttribute("dongsp1") DongSanPhamRequest dongSanPhamRequest,BindingResult result){
        if(result.hasErrors()){

        }


        iDongSanPhamService.update(dongSanPhamRequest,id);

        return "redirect:/dong-san-pham";

    }


}
