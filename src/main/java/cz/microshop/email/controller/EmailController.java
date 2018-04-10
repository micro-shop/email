package cz.microshop.email.controller;

import cz.microshop.email.model.Email;
import cz.microshop.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<HttpStatus> send(@RequestBody Email email)   {
        LOG.debug("Received email request: ", email);
        emailService.send(email);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
