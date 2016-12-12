package hu.esamu.rft.esamurft.dao;

import hu.esamu.rft.esamurft.dto.UserDTO;

public interface UserDAO {
    UserDTO save(UserDTO user);

    UserDTO findByDTO(UserDTO user);

    UserDTO findById(String id);

    UserDTO findUserByUsername(String username);
}
