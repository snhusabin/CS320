package example.com.ContactServices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.updateContact("1", "Jane", "Smith", "0987654321", "456 Avenue");
        Contact updatedContact = service.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Avenue", updatedContact.getAddress());
    }
}