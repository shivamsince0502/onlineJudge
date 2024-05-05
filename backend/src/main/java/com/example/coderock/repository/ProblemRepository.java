package com.example.coderock.repository;

import com.example.coderock.model.Problem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends MongoRepository<Problem, ObjectId> {
    @Query("{ 'problemNo' : ?0 }")
    Problem findProblemByProblemNo(Long problemNp);


}
