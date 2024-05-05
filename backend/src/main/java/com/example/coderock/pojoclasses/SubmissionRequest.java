package com.example.coderock.pojoclasses;

import lombok.*;
import org.bson.types.ObjectId;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubmissionRequest {
    private String submittedCode;
    private Long problemNo;
    private String username;
}
