package com.synx.controller;

import com.synx.model.Incident;
import com.synx.service.IncidentService;

import com.synx.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private MaterielService materielService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("incidents", incidentService.findAll());
        return "index";
    }

    @RequestMapping(value = "/addIncident", method = RequestMethod.GET)
    public String addIncidentView(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        model.addAttribute("materiels", materielService.findAll());
        return "addIncident";
    }

    @RequestMapping(value = "/addIncident", method = RequestMethod.POST)
    public String addIncident(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        Incident incident = new Incident(
                request.getParameter("idMateriel"),
                request.getParameter("titreIncient"),
                request.getParameter("descIncident"),
                new Date(),
                "Non traité"
                );
        incidentService.save(incident);
        return "redirect:/";
    }
}
