package com.example.coderock.repository;

import com.example.coderock.model.Submission;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubmissionRepository extends MongoRepository<Submission, ObjectId> {
}
