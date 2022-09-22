package com.demo.export.service;

import com.demo.export.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Contact findContactById(Integer id);

    int save(Contact contact);

    int deleteContactById(Integer id);
}
