package fr.kata.contact.annuairews.service;

import fr.kata.contact.annuairews.domain.Contact;

import java.util.List;

public interface ContactService {


    /**
     * find contact by serch creteria.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param company
     * @param departement
     */
    List<Contact> searchContact(String firstName, String lastName, String email, String company, String departement);
}
