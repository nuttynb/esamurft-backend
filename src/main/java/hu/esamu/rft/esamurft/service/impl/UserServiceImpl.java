package hu.esamu.rft.esamurft.service.impl;

import hu.esamu.rft.esamurft.dao.UserDAO;
import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.exception.AuthenticationException;
import hu.esamu.rft.esamurft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDTO save(UserDTO user) {
        return userDAO.save(user);
    }

    @Override
    public UserDTO findByDTO(UserDTO user) {
        return userDAO.findByDTO(user);
    }

    @Override
    public UserDTO findById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public UserDTO login(String username, String password) throws AuthenticationException {
        UserDTO user = userDAO.findUserByUsername(username);

        if (user == null) {
            String errorMessage = "Login failed: can't find user with username " + username;
            LOGGER.error(errorMessage);
            throw new AuthenticationException(errorMessage);
        }

        if (!user.getPassword().equals(password)) {
            String errorMessage = "Login failed: password is incorrect!";
            LOGGER.error(errorMessage);
            throw new AuthenticationException(errorMessage);
        }

        return user;
    }
}
