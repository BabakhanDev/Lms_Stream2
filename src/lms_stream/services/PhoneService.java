package lms_stream.services;

import lms_stream.models.Phone;

import java.util.List;

public interface PhoneService {

    String addPhone(Phone phone);

    Phone getPhoneById(Long phoneId);

    Phone getPhoneByIdWithStream(Long phoneId);

    Phone updatePhoneNameById(Long phoneId, String newName);

    Phone updatePhoneNameByIdWithStream(Long phoneId, String newName);

    List<Phone> getAllPhones();

    List<Phone> getAllPhonesWithStream();

    List<Phone> getAllPhonesByBrand(String brand);

    List<Phone> getAllPhonesByBrandWithStream(String brand);

    void deletePhoneById(Long phoneId);

    void deletePhoneByIdWithStream(Long phoneId);
}
