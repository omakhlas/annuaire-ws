package fr.kata.contact.annuairews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {



    @Test
    public void shouldReturnWhenContactNameIsAbagael() {
        assertEquals("Abagael", contactRepository.findByName());
    }
}
