package hu.esamu.rft.esamurft.service.impl;

import hu.esamu.rft.esamurft.dao.UserDAO;
import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO save(UserDTO user) {
        return userDAO.save(user);
    }

    @Override
    public UserDTO findById(UserDTO user) {
        return userDAO.findById(user);
    }
}
