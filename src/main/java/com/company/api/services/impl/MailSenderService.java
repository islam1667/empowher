package com.company.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String mailTo, String subject, String body){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(mailTo);
        mail.setSubject(subject);
        mail.setText(body);

        javaMailSender.send(mail);
    }
}
