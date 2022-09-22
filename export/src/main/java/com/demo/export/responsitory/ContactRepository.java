package com.demo.export.responsitory;


import com.demo.export.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {
    List<Contact> findByNameContaining(String term);
}
