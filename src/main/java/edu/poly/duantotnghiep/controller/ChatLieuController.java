package edu.poly.duantotnghiep.controller;

import edu.poly.duantotnghiep.service.IChatLieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("chat-lieu")
public class ChatLieuController {

    private final IChatLieuService chatLieuService;

    @GetMapping("")
    public String showAll(Model model) {



        return "admin/chatLieu";
    }
}

