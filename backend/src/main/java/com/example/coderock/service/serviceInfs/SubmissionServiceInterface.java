package com.example.coderock.service.serviceInfs;

import com.example.coderock.pojoclasses.SubmissionRequest;
import com.example.coderock.pojoclasses.SubmissionResponse;

public interface SubmissionServiceInterface {
    public SubmissionResponse createSubmission(SubmissionRequest submissionRequest);
}
