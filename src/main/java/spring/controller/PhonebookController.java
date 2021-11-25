package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.models.Client;
import spring.service.PhonebookService;

import java.util.List;

@RestController
public class PhonebookController {
    @Autowired
    PhonebookService phonebookService;

    @PutMapping("/addMember")
    @ResponseStatus(HttpStatus.CREATED)
    public Client addMember(@RequestBody Client client){
        return phonebookService.addMember(client);
    }

    @PutMapping("/addMembers")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Client> addMembers(@RequestBody List<Client> clients){
        return phonebookService.addMembers(clients);
    }

    @GetMapping("/deleteMemberById")
    @ResponseStatus(HttpStatus.OK)
    public Client  deleteMemberById(@RequestParam Integer id){
        return phonebookService.deleteMember(id);
    }

    @GetMapping("/deleteMemberByName")
    public Client deleteMemberByName(@RequestParam String firstName, @RequestParam String lastName){
        return phonebookService.deleteMember(firstName, lastName);
    }

    @GetMapping("/deleteMembersById")
    public List<Client> deleteMembersById(@RequestParam List<Integer> listId){
        return phonebookService.deleteMembers(listId);
    }

    @GetMapping("/getClients")
    public List<Client> getAllClients(){
        return phonebookService.getAllClients();
    }
}
