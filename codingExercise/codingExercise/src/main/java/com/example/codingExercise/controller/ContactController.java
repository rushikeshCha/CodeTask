package com.example.codingExercise.controller;

import com.example.codingExercise.dto.ContactDTO;
import com.example.codingExercise.entity.Contact;

import com.example.codingExercise.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService service;

    @PostMapping(value = "/addContact")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO createContact(@RequestBody ContactDTO contact) {
        return service.addContact(contact);
    }

    @GetMapping("/all-contacts")
    @ResponseStatus(HttpStatus.OK)
    public List<ContactDTO> allContacts(){
        return service.getAllContacts();
    }

    @GetMapping("/contacts-by-postal-code/{postalCode}")
    @ResponseStatus(HttpStatus.OK)
    public List<ContactDTO> contactsByPostalCode(@PathVariable String postalCode){
        return service.getContactsByPostalCode(postalCode);
    }
}
