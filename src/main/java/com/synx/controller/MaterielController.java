package com.synx.controller;

import com.synx.model.Materiel;
import com.synx.model.User;
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
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        model.addAttribute("materiels", materielService.findAll());
        model.addAttribute("users", userService.findAll());

        return "gestion_materiel";
    }

    @RequestMapping(value = "/addMateriel", method = RequestMethod.POST)
    public String addMateriel(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        Materiel materiel = new Materiel(
                request.getParameter("idUser"),
                request.getParameter("type"),
                request.getParameter("nbSerie")
        );
        materielService.save(materiel);

        return "redirect:/gestionMateriel";
    }

    @RequestMapping(value = "/editMateriel", method = RequestMethod.GET)
    public String editMaterielView(HttpServletRequest request, Model model) {
        if (request.getParameter("id") == null){
            return "redirect:/";
        }
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        model.addAttribute(
                "materiel",
                materielService.findMateriel(Integer.parseInt(request.getParameter("id")))
                );
        model.addAttribute("users", userService.findAll());

        return "edit_materiel";
    }

    @RequestMapping(value = "/editMateriel", method = RequestMethod.POST)
    public String editMateriel(HttpServletRequest request) {
        if (request.getParameter("id") == null){
            return "redirect:/";
        }
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        Materiel materiel = materielService.findMateriel(Integer.parseInt(request.getParameter("id")));
        materiel.setNbSerie(request.getParameter("nbSerie"));
        materiel.setType(request.getParameter("type"));
        materiel.setIdUser(Integer.parseInt(request.getParameter("idUser")));
        materielService.save(materiel);

        return "redirect:/gestionMateriel";
    }

    @RequestMapping(value = "/deleteMateriel", method = RequestMethod.GET)
    public String deleteMateriel(HttpServletRequest request) {
        if (request.getParameter("id") == null){
            return "redirect:/";
        }
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        materielService.delete(Integer.parseInt(request.getParameter("id")));

        return "redirect:/gestionMateriel";
    }
}
