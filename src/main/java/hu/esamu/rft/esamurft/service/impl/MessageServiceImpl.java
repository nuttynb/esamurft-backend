package hu.esamu.rft.esamurft.service.impl;

import hu.esamu.rft.esamurft.dao.MessageDAO;
import hu.esamu.rft.esamurft.mapper.MessageMapper;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;
import hu.esamu.rft.esamurft.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDAO messageDAO;

    @Override
    public void save(EsamuRFTMessages.item message) {
        messageDAO.save(MessageMapper.mapToDto(message));
    }
}
