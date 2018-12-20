package com.cmk.controller;

import com.cmk.entity.Admin;
import com.cmk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/login")
    public String login(String name, String password, HttpServletRequest request,String code){
        HttpSession session = request.getSession();

        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        if(!random.equals(code)){
            request.setAttribute("msg","验证码错误!");
            return "forward:/login.jsp";
        }
        try{
            Admin admin=adminService.login(name,password);

            session.setAttribute("admin", admin);
            return "redirect:/main/main.jsp";
        }catch (Exception e) {
            request.setAttribute("msg",e.getMessage());
            return "forward:/login.jsp";
        }

    }


    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.jsp";
    }

}
