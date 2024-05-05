package com.example.coderock.controller;

import com.example.coderock.pojoclasses.SubmissionRequest;
import com.example.coderock.pojoclasses.SubmissionResponse;
import com.example.coderock.service.serviceInfs.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coderock/submit")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;

    @PostMapping(value = "/question")
    public SubmissionResponse getSubmitResult(@RequestBody SubmissionRequest submissionRequest){
        return submissionServiceInterface.createSubmission(submissionRequest);
    }
}
