package com.finaltest.amqpconsumer.model;

import javax.persistence.*;

@Entity
@Table(name = "mail_report")
public class MailReportLog {

    public static final String STATUS_SUCSESS = "Succsess";
    public static final String STATUS_FAILED = "Failed";
    public static final String MEDIA_EMAIL = "Email";
    public static final String MEDIA_PHONE = "Phone";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String SendDate;

    @Column
    private String Message;

    @Column
    private String MediaType;

    @Column
    private String CostumerEmail;

    @Column
    private String Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSendDate() {
        return SendDate;
    }

    public void setSendDate(String sendDate) {
        SendDate = sendDate;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMediaType() {
        return MediaType;
    }

    public void setMediaType(String mediaType) {
        MediaType = mediaType;
    }

    public String getCostumerEmail() {
        return CostumerEmail;
    }

    public void setCostumerEmail(String costumerEmail) {
        CostumerEmail = costumerEmail;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
