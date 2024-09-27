package lms_stream.services;

import lms_stream.models.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(Long phoneId, Contact contact);

    Contact findContactByName(Long phoneId, String contactName);

    Contact findContactByNameWithStream(Long phoneId, String contactName);

    Contact findContactByPhoneNumber(Long phoneId, String phoneNumber);

    Contact findContactByPhoneNumberWithStream(Long phoneId, String phoneNumber);

    List<Contact> sortContactsByName(Long phoneId);

    List<Contact> sortContactsByNameWithStream(Long phoneId);
}
