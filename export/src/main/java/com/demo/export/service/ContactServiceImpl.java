package com.demo.export.service;


import com.demo.export.entity.Contact;
import com.demo.export.exception.ResourceNotFoundException;
import com.demo.export.responsitory.ContactRepository;
import com.demo.export.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String term) {
        return contactRepository.findByNameContaining(term);
    }

    @Override
    public Contact findContactById(Integer id) {
        Optional<Contact> cnt = contactRepository.findById(id);
        if (cnt.isPresent()) {
            return cnt.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public int save(Contact contact) {
        try {
            contactRepository.save(contact);
            return Const.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Const.ERROR;
        }

    }

    @Override
    public int deleteContactById(Integer id) {
        try {
            contactRepository.deleteById(id);
            return Const.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Const.ERROR;
        }

    }
}
