package com.escalade.victor.repository;

import com.escalade.victor.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
