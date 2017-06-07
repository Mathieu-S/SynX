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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String editIncident(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        if (request.getParameter("idIncident") == null){
            return "redirect:/";
        }

        Incident incident = incidentService.findIncident(Integer.parseInt(request.getParameter("idIncident")));
        incident.setStatus(request.getParameter("status"));
        if (!request.getParameter("status").equals("En cours")) {
            incident.setDateFin(new Date());
        }

        incidentService.save(incident);

        return "redirect:/";
    }

    @RequestMapping(value = "/addIncident", method = RequestMethod.GET)
    public String addIncidentView(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("materiels", materielService.findAll());

        return "add_incident";
    }

    @RequestMapping(value = "/addIncident", method = RequestMethod.POST)
    public String addIncident(HttpServletRequest request) {
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
