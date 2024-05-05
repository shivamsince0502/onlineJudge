package com.example.coderock.service.serviceImpl;

import com.example.coderock.model.User;
import com.example.coderock.repository.UserRepository;
import com.example.coderock.service.serviceInfs.UserServiceInterface;
import org.bson.types.ObjectId;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        if(user.getId() == null) user.setUserId(new ObjectId());
        if(user.getPassword() != "") user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public Boolean updateUser(User user) {
        Optional<User> currUser = userRepository.findById(user.getId());
        if(currUser.isPresent()) {
            User currUserObj = currUser.get();
            if (user.getUsername() != "" && (userRepository.findAll().stream().map(User::getUsername).
                    toList().contains(user.getUsername()))) {
                currUserObj.setUsername(user.getUsername());
            }
            if(currUserObj.getPassword() != ""){
                currUserObj.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            if(currUserObj.getEmail() != ""){
                currUserObj.setEmail(user.getEmail());
            }
            userRepository.save(currUserObj);
            return true;
        }
        return false;

    }

    @Override
    public Boolean deleteUser(ObjectId id) {
        Optional<User> currUser = userRepository.findById(id);
        if(currUser.isPresent()){
            User currUserObj = currUser.get();
            userRepository.delete(currUserObj);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findUserByUsername(userName);

    }

    @Override
    public User getUserByUserId(ObjectId id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) return  user.get();
        return null;
    }
}
