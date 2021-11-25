package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.models.Client;
import spring.repository.PhonebookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhonebookService {
    @Autowired
    PhonebookRepository phonebookRepository;

    @Transactional
    public Client addMember(Client client){
        return phonebookRepository.save(client);
    }

    @Transactional
    public List<Client> addMembers(List<Client> clients){
        return phonebookRepository.saveAll(clients);
    }

    @Transactional
    public Client deleteMember(int id){
         Optional<Client> client = phonebookRepository.findById(id);
         phonebookRepository.deleteById(id);
         return client.orElse(null);
    }

    @Transactional
    public Client deleteMember(String firstName, String lastName){
        Client client = phonebookRepository.findByFirstNameAndLastName(firstName, lastName);
        phonebookRepository.deleteClientByFirstNameAndLastName(firstName,lastName);
        return client;
    }

    @Transactional
    public List<Client> deleteMembers(List<Integer> idList){
        List<Client> clients = phonebookRepository.findAllById(idList);
        phonebookRepository.deleteAllById(idList);
        return clients;
    }

    public List<Client> getAllClients(){
        return phonebookRepository.findAll();
    }

    public Page<Client> getPageClients(Pageable page){
        return phonebookRepository.findAll(page);
    }

}
