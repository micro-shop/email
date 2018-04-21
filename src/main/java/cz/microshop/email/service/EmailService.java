package cz.microshop.email.service;

import cz.microshop.email.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private JavaMailSender mailSender;

    public void send(Email email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mimeMessage.setContent(email.getContent(), "text/html");
            helper.setTo(email.getTo());
            helper.setSubject("Microshop: Auto generated email, please do not respond");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOG.error("Exception occurred during sending email.", e);
        }
    }
}
