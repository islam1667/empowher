package com.company.api.services;

public interface MailService {
    Boolean sendMail(String to, String content);
}
