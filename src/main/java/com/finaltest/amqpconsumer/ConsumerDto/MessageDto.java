package com.finaltest.amqpconsumer.ConsumerDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MessageDto implements Serializable {

    @JsonProperty("customerEmail")
    private String customerEmail;

    @JsonProperty("transactionDate")
    private String transactionDate;

    @JsonProperty("transactionNumber")
    private Long transactionNumber;

    @JsonProperty("totalPayment")
    private Long totalPayment;


    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Long getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Long totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "ConsumerDto{" +
                "customerEmail='" + customerEmail + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionNumber=" + transactionNumber +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
