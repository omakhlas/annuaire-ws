package fr.kata.contact.annuairews.controller;

import fr.kata.contact.annuairews.service.ContactService;
import fr.kata.contact.annuairews.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value="/api")
public class ContactResource {


    private final Logger log = LoggerFactory.getLogger(ContactResource.class);

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }


    /**
     * {@code GET  /contacts} : get contacts by search criteria
     *
     * @param firstName the first name of the contact to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of contacts, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getContact(@RequestParam String firstName,
                                                    @RequestParam String lastName,
                                                    @RequestParam String email,
                                                    @RequestParam String company,
                                                    @RequestParam String departement) {
        log.info("REST request to get Contacts : {}");
        List<Contact> contacts = contactService.searchContact(firstName, lastName, email, company, departement);
        return ResponseEntity.ok()
                .body(contacts);
    }


}
