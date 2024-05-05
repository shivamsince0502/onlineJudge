package com.example.coderock.service.serviceImpl;

import com.example.coderock.service.serviceInfs.CppExecutor;
import com.example.coderock.enums.SubmissionStatus;
import com.example.coderock.model.Problem;
import com.example.coderock.model.Submission;
import com.example.coderock.pojoclasses.SubmissionRequest;
import com.example.coderock.pojoclasses.SubmissionResponse;
import com.example.coderock.repository.ProblemRepository;
import com.example.coderock.repository.SubmissionRepository;
import com.example.coderock.repository.UserRepository;
import com.example.coderock.service.serviceInfs.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CppExecutor cppExecutor;

    @Autowired
    private UserRepository userRepository;


    @Override
    public SubmissionResponse createSubmission(SubmissionRequest submissionRequest) {
        Problem problem = problemRepository.findProblemByProblemNo(submissionRequest.getProblemNo());
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setCode(submissionRequest.getSubmittedCode());
        submissionResponse.setStatus(SubmissionStatus.PENDING);
        submissionResponse = cppExecutor.getPassedTestCases(submissionRequest.getSubmittedCode(), problem.getHiddenCases(), problem.getResult(), submissionResponse);
        Submission submission = new Submission();
        submission.setProblem(problem);
        submission.setStatus(submissionResponse.getStatus());
        submission.setProblem(problem);
        submission.setUser(userRepository.findUserByUsername(submissionRequest.getUsername()));
        submission.setSolutionCode(submissionRequest.getSubmittedCode());
        submissionRepository.save(submission);
        return submissionResponse;
    }
}
