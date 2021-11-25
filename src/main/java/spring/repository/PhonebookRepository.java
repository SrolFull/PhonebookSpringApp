package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.models.Client;

@Repository
public interface PhonebookRepository extends JpaRepository<Client,Integer> {
    void deleteClientByFirstNameAndLastName(String firstName, String lastName);
    Client findByFirstNameAndLastName(String firstName, String lastName);
}
