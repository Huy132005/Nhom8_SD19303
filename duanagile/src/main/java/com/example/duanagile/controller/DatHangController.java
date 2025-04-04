package com.example.duanagile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DatHangController {
    @GetMapping("/datHang/hien-thi")
    public String hienThidatHang() {
        return "datHang/hien-thi";
    }
}
