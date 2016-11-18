package hu.esamu.rft.esamurft.dao;

import hu.esamu.rft.esamurft.dto.UserDTO;

public interface UserDAO {
    UserDTO save(UserDTO user);

    UserDTO findById(UserDTO user);

    UserDTO findUserByUsername(String username);
}
