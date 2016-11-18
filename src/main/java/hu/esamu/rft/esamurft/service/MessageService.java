package hu.esamu.rft.esamurft.service;

import hu.esamu.rft.esamurft.dto.MessageDTO;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;

import java.util.List;

public interface MessageService {
    void save(EsamuRFTMessages.item message);

    List<MessageDTO> findAll();

    void deleteAll();
}
