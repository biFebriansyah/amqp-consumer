package com.finaltest.amqpconsumer.repo;

import com.finaltest.amqpconsumer.model.MailReportLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface _MailRepo extends CrudRepository<MailReportLog, Integer> {
}
