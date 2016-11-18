package hu.esamu.rft.esamurft.service;

import hu.esamu.rft.esamurft.dto.UserDTO;

public interface UserService {
    UserDTO save(UserDTO user);

    UserDTO findById(UserDTO user);
}
