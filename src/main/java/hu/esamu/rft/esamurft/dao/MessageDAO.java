package hu.esamu.rft.esamurft.dao;

import hu.esamu.rft.esamurft.dto.MessageDTO;

public interface MessageDAO {
    void save(MessageDTO message);

    MessageDTO findById(MessageDTO message);
}
