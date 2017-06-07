package com.synx.controller;

import com.synx.model.Materiel;
import com.synx.service.MaterielService;
import com.synx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MaterielController {

    @Autowired
    private MaterielService materielService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/gestionMateriel", method = RequestMethod.GET)
    public String gestionMaterielView(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("materiels", materielService.findAll());
        model.addAttribute("users", userService.findAll());
        return "gestion_materiel";
    }

    @RequestMapping(value = "/addMateriel", method = RequestMethod.POST)
    public String addMateriel(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        Materiel materiel = new Materiel(
                request.getParameter("idUser"),
                request.getParameter("type"),
                request.getParameter("nbSerie")
        );
        materielService.save(materiel);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteMateriel", method = RequestMethod.GET)
    public String deleteMateriel(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getParameter("id") == null){
            return "redirect:/";
        }
        materielService.delete(Integer.parseInt(request.getParameter("id")));
        return "redirect:/";
    }
}
