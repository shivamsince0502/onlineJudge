package com.example.coderock.repository;

import com.example.coderock.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{ 'username' : ?0 }")
    User findUserByUsername(String username);

    @Query("{username : ?0, password : ?1}")
    User findUserByUsernameAndPassword(String username, String password);

}
