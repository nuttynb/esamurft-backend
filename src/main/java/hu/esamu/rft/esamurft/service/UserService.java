package hu.esamu.rft.esamurft.service;

import hu.esamu.rft.esamurft.dto.UserDTO;

public interface UserService {
    UserDTO save(UserDTO user);

    UserDTO findByDTO(UserDTO user);

    UserDTO findById(String id);

    UserDTO findByUsername(String username);
}
