package com.synx.controller;

import com.synx.model.User;
import com.synx.service.UserService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, Model model) {
        List<User> users = userService.findAll();
        for (User user : users) {
            if (user.getEmail().equals(request.getParameter("email"))) {
                StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                if (passwordEncryptor.checkPassword(request.getParameter("pswd"), user.getMdp())) {
                    request.getSession().setAttribute("user", user);
                    return "redirect:/";
                }
            }
        }
        return "login";
    }
}
