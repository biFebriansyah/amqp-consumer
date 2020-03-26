package com.finaltest.amqpconsumer.service;

import com.finaltest.amqpconsumer.ConsumerDto.MessageDto;
import com.finaltest.amqpconsumer.model.MailReportLog;
import com.finaltest.amqpconsumer.repo._MailRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConsumerListener {

    @Autowired
    sendEmailCostumer mail;

    @Autowired
    _MailRepo mailRepo;

    @RabbitListener(queues = "${finaltest.rabbitmq.queue}")
    public void onMessage(MessageDto message) {
        final String msg = "Detail Transaksi anda \n" + "TransactionDate = " + message.getTransactionDate() + "\n" + "Tansaction Number = " + message.getTransactionNumber().toString() + "\n" + "Total Payment = " + message.getTotalPayment().toString();
        MailReportLog data = new MailReportLog();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        try {
            System.out.println(message.getCustomerEmail());
            mail.Send(msg, message.getCustomerEmail());
            data.setCostumerEmail(message.getCustomerEmail());
            data.setMediaType(MailReportLog.MEDIA_PHONE);
            data.setSendDate(date.format(dateTimeFormatter));
            data.setMessage(msg);
            data.setStatus(MailReportLog.STATUS_SUCSESS);
            mailRepo.save(data);

        } catch (MessagingException e) {
            data.setCostumerEmail(message.getCustomerEmail());
            data.setMediaType(MailReportLog.MEDIA_PHONE);
            data.setSendDate(date.format(dateTimeFormatter));
            data.setMessage(msg);
            data.setStatus(MailReportLog.STATUS_FAILED);
            mailRepo.save(data);

            System.out.println(e.getMessage());
        } catch (IOException er) {
            data.setCostumerEmail(message.getCustomerEmail());
            data.setMediaType(MailReportLog.MEDIA_PHONE);
            data.setSendDate(date.format(dateTimeFormatter));
            data.setMessage(msg);
            data.setStatus(MailReportLog.STATUS_FAILED);
            mailRepo.save(data);
            System.out.println(er.getMessage());
        }
    }
}
