package lms_stream;

import lms_stream.database.Database;
import lms_stream.models.Contact;
import lms_stream.models.Phone;
import lms_stream.services.impl.ContactServiceImpl;
import lms_stream.services.impl.PhoneServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        ContactServiceImpl contactService = new ContactServiceImpl(database);
        PhoneServiceImpl phoneService = new PhoneServiceImpl(database);
        Contact contact1 = new Contact("Аманбек", "0700-123456");
        Contact contact2 = new Contact("Бактыбек", "0701-234567");
        Contact contact3 = new Contact("Жазгүл", "0702-345678");
        Contact contact4 = new Contact("Канат", "0703-456789");
        Contact contact5 = new Contact("Мээрим", "0704-567890");
        Contact contact6 = new Contact("Улан", "0705-678901");
        Contact contact7 = new Contact("Гүлнур", "0706-789012");
        Contact contact8 = new Contact("Эрмек", "0707-890123");
        Contact contact9 = new Contact("Асел", "0708-901234");
        Contact contact10 = new Contact("Нуржан", "0709-012345");



        Phone phone1 = new Phone(1L, "Samsung A50", "Samsung", List.of(contact1, contact2));
        Phone phone2 = new Phone(2L, "iPhone 13", "Apple", List.of(contact3));
        Phone phone3 = new Phone(3L, "Redmi Note 10", "Xiaomi", List.of(contact4));
        Phone phone4 = new Phone(4L, "Pixel 6", "Google", List.of(contact5));
        Phone phone5 = new Phone(5L, "Galaxy S21", "Samsung", List.of(contact1, contact3));
        Phone phone6 = new Phone(6L, "OnePlus 9", "OnePlus", List.of(contact2, contact4));
        Phone phone7 = new Phone(7L, "Nokia 3310", "Nokia", List.of(contact5));
        Phone phone8 = new Phone(8L, "Huawei P30", "Huawei", List.of(contact1, contact5));
        Phone phone9 = new Phone(9L, "Sony Xperia", "Sony", List.of(contact2, contact3));
        Phone phone10 = new Phone(10L, "LG V60", "LG", List.of(contact4));



        phoneService.addPhone(phone1);
        phoneService.addPhone(phone2);
        phoneService.addPhone(phone3);
        phoneService.addPhone(phone4);
        phoneService.addPhone(phone5);
        phoneService.addPhone(phone6);
        phoneService.addPhone(phone7);
        phoneService.addPhone(phone8);
        phoneService.addPhone(phone9);
        phoneService.addPhone(phone10);
        phoneService.addPhone(phone10);
//        System.out.println(contactService.addContactToPhone(1L, contact6));
//
        System.out.println(contactService.addContactToPhone(9L, contact8));                           //1
        System.out.println(contactService.findContactByPhoneNumber(9L, "0707-890123"));    //2 вместе работает
//        System.out.println(" ");
//        System.out.println(contactService.findContactByName(7L, "Мээрим"));
//        System.out.println(contactService.findContactByNameWithStream(7L, "Мээрим"));
//        System.out.println(contactService.sortContactsByName(6L));
//        System.out.println(contactService.sortContactsByNameWithStream(9L));
//        contactService.addContactToPhone(1L,contact3);
//        System.out.println(contactService.findContactByName(1L, "Жазгүл"));
//        System.out.println(phoneService.getAllPhones());
//        for (Phone allPhone : phoneService.getAllPhones()) {
//            System.out.println(allPhone);
//        }
//        System.out.println("Stream");
//        for (Phone phone : phoneService.getAllPhonesWithStream()) {
//            System.out.println(phone);
//        }

}}