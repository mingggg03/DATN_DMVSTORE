package edu.poly.duantotnghiep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thuong-hieu")
public class ThuongHieuController {
    @GetMapping("")
    public String show(){
        return "/admin/thuongHieu";
    }
}
