package com.example.codingExercise.util;

import com.example.codingExercise.dto.AddressDTO;
import com.example.codingExercise.dto.ContactDTO;
import com.example.codingExercise.entity.Address;
import com.example.codingExercise.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactUtil {
    public ContactDTO contactToDTO(Contact contact) {
        ContactDTO contactDTO=new ContactDTO();
        contactDTO.setId(contact.getContactId());
        contactDTO.setFullName(contact.getFullName());
        contactDTO.setDateOfBirth(contact.getDateOfBirth());

        AddressDTO addressDTO=new AddressDTO();
        Address address=contact.getAddress();
        addressDTO.setId(address.getAddressId());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        contactDTO.setAddressDTO(addressDTO);
        contactDTO.setAddressDTO(addressDTO);
        return contactDTO;
    }
    public List<ContactDTO> contactToDTOList(List<Contact> contacts) {
        List<ContactDTO> list=new ArrayList<>();
        for(Contact contact:contacts){
            ContactDTO contactDTO=new ContactDTO();
            contactDTO.setId(contact.getContactId());
            contactDTO.setFullName(contact.getFullName());
            contactDTO.setDateOfBirth(contact.getDateOfBirth());

            AddressDTO addressDTO=new AddressDTO();
            Address address=contact.getAddress();
            addressDTO.setId(address.getAddressId());
            addressDTO.setCity(address.getCity());
            addressDTO.setPostalCode(address.getPostalCode());
            contactDTO.setAddressDTO(addressDTO);
            contactDTO.setAddressDTO(addressDTO);
            list.add(contactDTO);
        }
        return list;
    }
}
