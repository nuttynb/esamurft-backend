package hu.esamu.rft.esamurft.service;

import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.exception.AuthenticationException;

public interface UserService {

    UserDTO save(UserDTO user);

    UserDTO findByDTO(UserDTO user);

    UserDTO findById(String id);

    UserDTO findByUsername(String username);

    UserDTO login(String username, String password) throws AuthenticationException;
}
