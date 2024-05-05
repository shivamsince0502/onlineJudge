package com.example.coderock.service.serviceInfs;

import com.example.coderock.model.Problem;
import com.example.coderock.pojoclasses.ProblemRequest;
import com.example.coderock.pojoclasses.ProblemResponse;

public interface ProblemServiceInterface {
    public ProblemResponse createProblem(ProblemRequest problemRequest);
    public ProblemResponse updateProblem(ProblemRequest problemRequest);
    public ProblemResponse getProblemByProblemNo(Long problemNo);
}
