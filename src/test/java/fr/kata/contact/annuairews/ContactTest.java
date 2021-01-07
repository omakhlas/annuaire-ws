package fr.kata.contact.annuairews;

import fr.kata.contact.annuairews.domain.Contact;
import fr.kata.contact.annuairews.repository.ContactRepository;
import fr.kata.contact.annuairews.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactTest {

    @Autowired
    private ContactService contactService;

    List<Contact> contacts = new ArrayList<>();

    @BeforeEach
    public void init() {
        contacts = contactService.searchContact("Leonardo","Amor", "lamor0@utexas.edu", "Devshare", "Sales");
    }

    @Test
    public void shouldReturnWhenContactNameIsAbagael() {
        assertEquals("Leonardo", contacts.get(0).getFirst_name());
    }
}
