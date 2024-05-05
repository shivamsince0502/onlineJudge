package com.example.coderock.model;

import com.example.coderock.enums.SubmissionStatus;
import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "submission")
@Data
public class Submission {
    @Id
    private ObjectId id;
    private String solutionCode;
    private SubmissionStatus status;
    @DBRef
    private Problem problem;
    @DBRef
    private User user;
}
