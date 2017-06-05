package com.synx.controller;

import com.synx.service.IncidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @Autowired
    private IncidentService incidentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("incidents", incidentService.findAll());
        return "index";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String testy(HttpServletRequest request, Model model) {
//        model.addAttribute("user", userService.findUser(1));
//        System.out.println(request.getParameter("pass"));
//        return "index";
//    }
}
