package com.example.duanagile.controller;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequestMapping("/Taikhoan")
public class AuthController {
    public class AuthController {

        @GetMapping("/dang-nhap")
        public String showLoginForm() {
            return "dangnhap";  // Trả về view đăng nhập
        }
        @GetMapping("/dang-ky")
        public String showLoginForm() {
            return "dangky";  // Trả về view đăng nhập
        } }
}
