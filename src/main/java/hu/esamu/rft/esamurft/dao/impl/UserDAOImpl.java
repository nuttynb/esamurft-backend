package hu.esamu.rft.esamurft.dao.impl;

import hu.esamu.rft.esamurft.dao.UserDAO;
import hu.esamu.rft.esamurft.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public UserDTO save(UserDTO user) {
        mongoOperations.save(user);
        return user;
    }

    @Override
    public UserDTO findByDTO(UserDTO user) {
        return mongoOperations.findById(user, UserDTO.class);
    }

    @Override
    public UserDTO findById(String id) {
        Query searchUserQuery = new Query(Criteria.where("userId").is(id));
        return mongoOperations.findOne(searchUserQuery, UserDTO.class);
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        Query searchUserQuery = new Query(Criteria.where("username").is(username));
        return mongoOperations.findOne(searchUserQuery, UserDTO.class);
    }
}
