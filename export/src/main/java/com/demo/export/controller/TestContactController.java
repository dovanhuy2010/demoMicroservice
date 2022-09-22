package com.demo.export.controller;

import com.demo.export.entity.Contact;
import com.demo.export.service.ContactService;
import com.demo.export.utils.Const;
import com.demo.export.utils.Response;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestContactController {
    private final Logger logger = LogManager.getLogger(TestContactController.class);

    private final ContactService contactService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getContact(){
        List<Contact> Contacts = (List<Contact>) contactService.findAll();

        Response response = new Response(Const.DataRes.SUCCESS.getCode(),Const.DataRes.SUCCESS.getMessage(), Contacts,"");
        logger.info("get data success");
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<?> createContact(@RequestBody Contact contact){
        contactService.save(contact);
        return ResponseEntity.ok(contact);
    }

    @RequestMapping(value = "/get-contact",method = RequestMethod.GET)
    public ResponseEntity<?> findContactById(@RequestBody int id){
        Contact contact = contactService.findContactById(id);
        return ResponseEntity.ok(contact);
    }

    @RequestMapping(value = "/delete-contact",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContactById(@RequestBody int id){
        contactService.deleteContactById(id);
        return ResponseEntity.ok("SUCCESS");
    }
}
