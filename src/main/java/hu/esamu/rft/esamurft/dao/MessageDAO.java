package hu.esamu.rft.esamurft.dao;

import hu.esamu.rft.esamurft.dto.MessageDTO;

import java.util.List;

public interface MessageDAO {
    void save(MessageDTO message);

    MessageDTO findById(MessageDTO message);

    List<MessageDTO> findAll();

    void deleteAll();
}
