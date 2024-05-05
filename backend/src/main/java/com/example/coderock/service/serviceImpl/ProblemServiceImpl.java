package com.example.coderock.service.serviceImpl;

import com.example.coderock.model.Problem;
import com.example.coderock.model.Tag;
import com.example.coderock.pojoclasses.ProblemRequest;
import com.example.coderock.pojoclasses.ProblemResponse;
import com.example.coderock.pojoclasses.TagRequest;
import com.example.coderock.repository.ProblemRepository;
import com.example.coderock.repository.TagRepository;
import com.example.coderock.service.serviceInfs.ProblemServiceInterface;
import com.example.coderock.service.serviceInfs.TagServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemServiceInterface {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private TagServiceItf tagServiceItf;

    @Override
    public ProblemResponse createProblem(ProblemRequest problemRequest) {
        Problem problem = new Problem();
        problem.setProblemNo(problemRequest.getProblemNo());
        problem.setProblemTitle(problem.getProblemTitle());
        problem.setDescription(problemRequest.getProblemDescription());
        problem.setResult(problemRequest.getResult());
        problem.setTag(createTagList(problemRequest.getTags()));
        problem.setHiddenCases(problemRequest.getHiddenTestCase());
        problem.setSampleCases(problemRequest.getSampleTestCase());
        problem = problemRepository.save(problem);
        ProblemResponse problemResponse = new ProblemResponse();
        problemResponse.setDescription(problem.getDescription());
        problemResponse.setProblemTitle(problem.getProblemTitle());
        problemResponse.setProblemNo(problem.getProblemNo());
        problemResponse.setTag(problem.getTag());
        problemResponse.setHiddenCases(problem.getHiddenCases());
        problemResponse.setResult(problem.getResult());
        problemResponse.setSampleCases(problem.getSampleCases());
        return problemResponse;
    }

    @Override
    public ProblemResponse updateProblem(ProblemRequest problemRequest) {
        Problem problem = problemRepository.findProblemByProblemNo(problemRequest.getProblemNo());
        if(problem == null) return null;
        if(problemRequest.getProblemNo() != null) problem.setProblemNo(problemRequest.getProblemNo());
        if(problemRequest.getProblemTitle() != null) problem.setProblemTitle(problem.getProblemTitle());
        if(problemRequest.getProblemDescription() != null) problem.setDescription(problemRequest.getProblemDescription());
        problem =  problemRepository.save(problem);
        ProblemResponse problemResponse = new ProblemResponse();
        problemResponse.setDescription(problem.getDescription());
        problemResponse.setProblemTitle(problem.getProblemTitle());
        problemResponse.setProblemNo(problem.getProblemNo());
        problemResponse.setTag(problem.getTag());
        problemResponse.setHiddenCases(problem.getHiddenCases());
        problemResponse.setResult(problem.getResult());
        problemResponse.setSampleCases(problem.getSampleCases());
        return problemResponse;
    }

    @Override
    public ProblemResponse getProblemByProblemNo(Long problemNo) {
        Problem problem = problemRepository.findProblemByProblemNo(problemNo);
        ProblemResponse problemResponse = new ProblemResponse();
        problemResponse.setDescription(problem.getDescription());
        problemResponse.setProblemTitle(problem.getProblemTitle());
        problemResponse.setProblemNo(problem.getProblemNo());
        problemResponse.setTag(problem.getTag());
        problemResponse.setHiddenCases(problem.getHiddenCases());
        problemResponse.setResult(problem.getResult());
        problemResponse.setSampleCases(problem.getSampleCases());
        return problemResponse;
    }

    private List<Tag> createTagList(List<TagRequest> tagRequests){
        return tagServiceItf.getAllTagsFromTagReq(tagRequests);
    }
}
