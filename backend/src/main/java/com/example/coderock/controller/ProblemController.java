package com.example.coderock.controller;


import com.example.coderock.pojoclasses.ProblemRequest;
import com.example.coderock.pojoclasses.ProblemResponse;
import com.example.coderock.service.serviceInfs.ProblemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coderock/problem")
public class ProblemController {

    @Autowired
    private ProblemServiceInterface problemServiceInterface;

    @GetMapping(value = "/getproblem/{problemNo}")
    ProblemResponse getProblem(@PathVariable(value = "problemNo") Long problemNo){
        return problemServiceInterface.getProblemByProblemNo(problemNo);
    }

    @PostMapping(value = "/create-problem")
    ProblemResponse createProblem(@RequestBody ProblemRequest problemRequest){
        return problemServiceInterface.createProblem(problemRequest);
    }
}
