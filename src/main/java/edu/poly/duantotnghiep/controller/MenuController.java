package edu.poly.duantotnghiep.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("${admin.domain}/index")
public class MenuController {

    @GetMapping("")
    public String ShowAll(){
        return "/admin/index";
    }
}
