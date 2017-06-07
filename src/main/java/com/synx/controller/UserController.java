package com.synx.controller;

import com.synx.model.User;
import com.synx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/gestionUtilisateur", method = RequestMethod.GET)
    public String gestionUserView(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        model.addAttribute("users", userService.findAll());

        return "gestion_utilisateur";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        User connectedUser = (User) request.getSession().getAttribute("user");
        if (connectedUser.getRole().equals("User")) {
            return "redirect:/";
        }

        User user = new User(
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("email"),
                request.getParameter("mdp"),
                request.getParameter("role")
        );
        userService.save(user);

        return "redirect:/gestionUtilisateur";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUserView(HttpServletRequest request, Model model) {
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
                "user",
                userService.findUser(Integer.parseInt(request.getParameter("id")))
        );

        return "edit_utilisateur";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
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

        User user = userService.findUser(Integer.parseInt(request.getParameter("id")));
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setEmail(request.getParameter("email"));
        user.setRole(request.getParameter("role"));
        if (!request.getParameter("mdp").equals("null")) {
            user.setMdp(request.getParameter("mdp"));
        }
        userService.save(user);

        return "redirect:/gestionUtilisateur";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
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

        userService.delete(Integer.parseInt(request.getParameter("id")));

        return "redirect:/gestionUtilisateur";
    }
}
