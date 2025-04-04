package com.example.duanagile.controller;

import com.example.duanagile.model.User;
import com.example.duanagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Taikhoan")
public class AuthController {

    @Autowired
    private UserService userService; // Inject service để xử lý logic đăng ký và đăng nhập

    @GetMapping("/dang-nhap")
    public String dangNhap() {
        return "dangNhap";  // Trả về view đăng nhập
    }

    @GetMapping("/dang-ky")
    public String dangKy() {
        return "dangKy";  // Trả về view đăng ký
    }

    // Đăng ký tài khoản
    @PostMapping("/dang-ky")
    public String registerUser(@ModelAttribute("user") User user) {
        // Mã hóa mật khẩu và lưu tài khoản
        userService.registerUser(user);
        return "redirect:/Taikhoan/dang-nhap";  // Chuyển hướng đến trang đăng nhập sau khi đăng ký
    }

    // Đăng nhập
    @PostMapping("/dang-nhap")
    public String loginUser(@ModelAttribute("user") User user) {
        boolean isValid = userService.validatePassword(user.getPassword(), userService.getUserByEmail(user.getEmail()).getPassword());
        if (isValid) {
            return "redirect:/home";  // Đăng nhập thành công, chuyển hướng đến trang chính
        } else {
            return "dangNhap";  // Nếu mật khẩu không đúng, quay lại trang đăng nhập
        }
    }
}
