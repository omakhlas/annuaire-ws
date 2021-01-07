package fr.kata.contact.annuairews.service;

import fr.kata.contact.annuairews.domain.Contact;
import fr.kata.contact.annuairews.repository.ContactPredicate;
import fr.kata.contact.annuairews.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{


    private final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactRepository contactRepository;


    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    //@Transactional(readOnly = true)
    public List<Contact> searchContact(String firstName, String lastName, String email, String company, String departement) {
        List<Contact> contacts = new ArrayList<>();
        contactRepository.findAll(ContactPredicate.findBySearchCriteria(firstName, lastName, email, company, departement))
                .forEach(contacts::add);
        return contacts;
    }
}
