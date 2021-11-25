package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.service.PhonebookService;

@Controller
public class ViewController {
    @Autowired
    PhonebookService phonebookService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("clients",phonebookService.getAllClients());
        return "index";
    }
}
