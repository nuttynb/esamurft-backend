package hu.esamu.rft.esamurft.service;

import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;

public interface MessageService {
    void save(EsamuRFTMessages.item message);
}
