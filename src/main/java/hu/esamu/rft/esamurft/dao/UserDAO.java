package hu.esamu.rft.esamurft.dao;

import hu.esamu.rft.esamurft.dto.UserDTO;

public interface UserDAO {
    void save(UserDTO user);

    UserDTO findById(UserDTO user);

    UserDTO findUserByUsername(String username);
}
