package hu.esamu.rft.esamurft.dao.impl;

import hu.esamu.rft.esamurft.dao.MessageDAO;
import hu.esamu.rft.esamurft.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void save(MessageDTO message) {
        mongoOperations.save(message);
    }

    @Override
    public MessageDTO findById(MessageDTO message) {
        return mongoOperations.findById(message, MessageDTO.class);
    }

    @Override
    public List<MessageDTO> findAll() {
        return mongoOperations.findAll(MessageDTO.class);
    }

    @Override
    public void deleteAll() {
        mongoOperations.dropCollection(MessageDTO.class);
    }
}
