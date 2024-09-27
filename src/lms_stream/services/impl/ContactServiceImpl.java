package lms_stream.services.impl;

import lms_stream.database.Database;
import lms_stream.models.Contact;
import lms_stream.models.Phone;
import lms_stream.services.ContactService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ContactServiceImpl implements ContactService {
    private final Database database;

    public ContactServiceImpl(Database database) {
        this.database = database;
    }


    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        Optional<Phone> phoneOptional = database.phones.stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .findFirst();
        if (phoneOptional.isPresent()) {
            phoneOptional.get().getContacts().add(contact);
            return "Contact added successfully: " + contact;
        }
        return "Phone not found with ID: " + phoneId;
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        for (Phone phone : database.phones) {
            if (phone.getId().equals(phoneId)){
                for (Contact contact : phone.getContacts()) {
                    if (contact.getName().equals(contactName)){
                        return contact;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Contact findContactByNameWithStream(Long phoneId, String contactName) {
        return database.phones.stream()
                .filter(p -> p.getId().equals(phoneId))
                .flatMap(p ->p.getContacts().stream())
                .filter(c -> c.getName().equals(contactName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        for (Phone phone : database.phones) {
            if (phone.getId().equals(phoneId)) {
                for (Contact contact : phone.getContacts()) {
                    if (contact.getPhoneNumber().equals(phoneNumber)) {
                        return contact;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override
    public Contact findContactByPhoneNumberWithStream(Long phoneId, String phoneNumber) {
        return database.phones.stream()
                .filter(p -> p.getId().equals(phoneId))
                .flatMap(p -> p.getContacts().stream())
                .filter(i -> i.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        for (Phone phone : database.phones) {
           if (phone.getId().equals(phoneId) ){
               List<Contact> contacts = new ArrayList<>(phone.getContacts());
               if (contacts != null && !contacts.isEmpty()) {
                   contacts.sort(Comparator.comparing(Contact::getName));
                   return contacts;
               } else {
                   System.out.println("Contacts are empty id: " + phoneId);
                   return List.of();
               }
           }
        }
        System.out.println("Phone not found with id: " + phoneId);
        return List.of();
    }

    @Override
    public List<Contact> sortContactsByNameWithStream(Long phoneId) {
        return database.phones.stream()
                .filter(p -> p.getId().equals(phoneId))
                .flatMap(p -> p.getContacts().stream())
                .sorted(Comparator.comparing(Contact::getName))
                .toList();
    }
}
