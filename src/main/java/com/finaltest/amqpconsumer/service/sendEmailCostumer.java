package com.finaltest.amqpconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public class sendEmailCostumer {

    @Autowired
    private JavaMailSender javaMailSender;

    public void Send(String msg, String customerEmail ) throws MessagingException, IOException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customerEmail);
        message.setSubject("Struck Tansaksi");
        message.setText(msg);
        javaMailSender.send(message);
    }
}
