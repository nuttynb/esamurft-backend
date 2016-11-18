package hu.esamu.rft.esamurft.service.impl;

import hu.esamu.rft.esamurft.dao.MessageDAO;
import hu.esamu.rft.esamurft.dto.MessageDTO;
import hu.esamu.rft.esamurft.mapper.MessageMapper;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;
import hu.esamu.rft.esamurft.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDAO messageDAO;

    @Override
    public void save(EsamuRFTMessages.item message) {
        messageDAO.save(MessageMapper.mapToDto(message));
    }

    @Override
    public List<MessageDTO> findAll() {
        return messageDAO.findAll();
    }

    @Override
    public void deleteAll() {
        messageDAO.deleteAll();
    }
}
