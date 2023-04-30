package com.example.codingExercise.service;

import com.example.codingExercise.dto.AddressDTO;
import com.example.codingExercise.dto.ContactDTO;
import com.example.codingExercise.entity.Address;
import com.example.codingExercise.entity.Contact;
import com.example.codingExercise.exception.ContactException;
import com.example.codingExercise.repository.AddressRepository;
import com.example.codingExercise.repository.ContactRepository;
import com.example.codingExercise.util.ContactUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    ContactUtil util;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private int contactLogCounter =0;

    @Override
    public ContactDTO addContact(ContactDTO contactdto) {
        Optional<Address> optionalAddress = addressRepository.findAddressByPostalCode(contactdto.getAddressDTO().getPostalCode());

        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            Contact contact = new Contact();
            contact.setFullName(contactdto.getFullName());
            contact.setDateOfBirth(contactdto.getDateOfBirth());
            contact.setAddress(address);
            contact = contactRepository.save(contact);

            //Logger to Log the Contact When Adding
            logger.info("Contact-"+(++contactLogCounter), contact);
            ContactDTO contactDTO=util.contactToDTO(contact);
            return contactDTO;
        }

        Address address = new Address();
        address.setCity(contactdto.getAddressDTO().getCity());
        address.setPostalCode(contactdto.getAddressDTO().getPostalCode());
        Contact contact = new Contact();
        contact.setFullName(contactdto.getFullName());
        contact.setDateOfBirth(contactdto.getDateOfBirth());
        contact.setAddress(address);
        contact = contactRepository.save(contact);
        ContactDTO contactDTO=util.contactToDTO(contact);

        //Logger to Log the Contact When Adding
        logger.info("Contact-"+(++contactLogCounter), contact);
        return contactDTO;
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> allContacts = contactRepository.findAll();
        if(allContacts.isEmpty()){
            throw new ContactException("No Contact present at the moment");
        }
        List<ContactDTO> contactDTOS=util.contactToDTOList(allContacts);
        return contactDTOS;
    }

    @Override
    public List<ContactDTO> getContactsByPostalCode(String postalCode) {
        List<Contact> contacts = contactRepository.findByAddressPostalCode(postalCode);
        if(contacts.isEmpty()){
            throw new ContactException("No Contact present with the PostalCode : "+postalCode);
        }
        List<ContactDTO> contactDTOS=util.contactToDTOList(contacts);
        return contactDTOS;
    }
}
