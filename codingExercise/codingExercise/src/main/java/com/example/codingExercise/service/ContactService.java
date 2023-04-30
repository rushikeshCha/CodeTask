package com.example.codingExercise.service;

import com.example.codingExercise.dto.ContactDTO;
import com.example.codingExercise.entity.Contact;

import java.util.List;
public interface ContactService {
    ContactDTO addContact(ContactDTO contactdto);
    List<ContactDTO> getAllContacts();
    List<ContactDTO> getContactsByPostalCode(String postalCode);
}
