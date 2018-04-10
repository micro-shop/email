package cz.microshop.email.service;

import cz.microshop.email.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void send(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Microshop: Auto generated email, please do not respond");
        message.setText(email.getContent());
        message.setTo(email.getTo());
        mailSender.send(message);
    }
}
