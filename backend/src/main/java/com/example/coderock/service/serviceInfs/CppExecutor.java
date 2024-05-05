package com.example.coderock.service.serviceInfs;

import com.example.coderock.pojoclasses.SubmissionResponse;

import java.util.List;


public interface CppExecutor {
    public SubmissionResponse getPassedTestCases(String code, List<String> testCase, List<String> result,
                                                 SubmissionResponse submissionResponse);
}
