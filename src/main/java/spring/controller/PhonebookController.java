package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import spring.models.Client;
import org.springframework.data.domain.Page;
import spring.service.PhonebookService;

import javax.naming.Binding;
import java.util.Map;
import java.util.Optional;

@Controller
public class PhonebookController {
    @Autowired
    PhonebookService phonebookService;

    @GetMapping("/addClient")
    public ModelAndView showForm(){
        return new ModelAndView("AddMemberPage","client",new Client());
    }

    @PostMapping("/submit")
    public ModelAndView submit(@ModelAttribute("client") Client client, BindingResult result, ModelMap modelMap){
        ModelAndView model = new ModelAndView("AddMemberPage","client",new Client());
        phonebookService.addMember(client);
        return model;
    }

    @PutMapping("/addMembers")
    @ResponseStatus(HttpStatus.OK)
    public String addMembers(Model model){
        return null;
    }

    @GetMapping("/deleteMemberById")
    @ResponseStatus(HttpStatus.OK)
    public String  deleteMemberById(Model model){
        return null;
    }

    @GetMapping("/deleteMemberByName")
    public String deleteMemberByName(Model model){
        return null;
    }

    @GetMapping("/deleteMembersById")
    public String deleteMembersById(Model model){
        return null;
    }

    @GetMapping("/getClients")
    public String getAllClients(@RequestParam(name = "page",defaultValue = "0") Integer pageNumber, Model model){
        Pageable pgable = PageRequest.of(pageNumber, 10);
        Page<Client> clientPage = phonebookService.getPageClients(pgable);
        model.addAttribute("clientList", clientPage.getContent());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", clientPage.getTotalPages());
        return "MembersList";
    }
}
