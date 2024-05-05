package com.example.coderock.pojoclasses;

import com.example.coderock.enums.SubmissionStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubmissionResponse {
    private int totalTestcase;
    private int passedCases;
    private int failedCases;
    private int problemNo;
    private String code;
    private SubmissionStatus status;
}
