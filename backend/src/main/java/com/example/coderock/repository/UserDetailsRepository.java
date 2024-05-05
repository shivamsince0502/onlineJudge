package com.example.coderock.repository;

import com.example.coderock.model.UserDetails;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepository extends MongoRepository<UserDetails, ObjectId> {
}
