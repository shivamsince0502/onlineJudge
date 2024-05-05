package com.example.coderock.service.serviceInfs;

import com.example.coderock.model.User;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    public User createUser(User user);
    public Boolean updateUser(User user);
    public Boolean deleteUser(ObjectId id);
    public List<User> getAllUsers();
    public User getUserByUserName(String userName);
    public User getUserByUserId(ObjectId id);

}
