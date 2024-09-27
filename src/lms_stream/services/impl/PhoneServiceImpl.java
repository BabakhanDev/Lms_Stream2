package lms_stream.services.impl;

import lms_stream.database.Database;
import lms_stream.models.Phone;
import lms_stream.services.PhoneService;

import java.util.ArrayList;
import java.util.List;


public class PhoneServiceImpl implements PhoneService {
    private final Database database;

    public PhoneServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addPhone(Phone phone) {
        database.phones.add(phone);
        return "Successfully added: ";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        for (Phone phone : database.phones) {
            if (phone.getId().equals(phoneId))
                return phone;
        }
        return null;
    }

    @Override
    public Phone getPhoneByIdWithStream(Long phoneId) {
      return database.phones.stream()
              .filter(o-> o.getId().equals(phoneId))
              .findFirst()
              .orElse(null);
          }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        for (Phone phone : database.phones) {
            if (phone.getId().equals(phoneId)){
                phone.setName(newName);
                System.out.println(" Successfully updated: ");
            }
        }
        return null;
    }

    @Override
    public Phone updatePhoneNameByIdWithStream(Long phoneId, String newName) {
       return database.phones.stream()
               .filter(p->p.getId().equals(phoneId))
                .peek(phone -> phone.setName(newName))
               .findFirst()
               .orElse(null);
    }

    @Override
    public List<Phone> getAllPhones() {
        return database.phones;
    }

    @Override
    public List<Phone> getAllPhonesWithStream() {
     return database.phones;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone> byBrand = new ArrayList<>();
        for (Phone phone : database.phones) {
            if (phone.getBrand().equals(brand)){
                byBrand.add(phone);
                return byBrand;
            }
        }
        return null;
    }

    @Override
    public List<Phone> getAllPhonesByBrandWithStream(String brand) {
       return database.phones.stream()
                .filter(p ->p.getBrand().equals(brand))
               .toList();
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        for (Phone phone : database.phones) {
            if (phone.getId().equals(phoneId)){
                database.phones.remove(phone);
            }
        }
    }

    @Override
    public void deletePhoneByIdWithStream(Long phoneId) {
        database.phones.removeIf(p -> p.getId().equals(phoneId));

    }
}
