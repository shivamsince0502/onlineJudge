package com.example.coderock.service.serviceImpl;

import com.example.coderock.enums.SubmissionStatus;
import com.example.coderock.pojoclasses.SubmissionResponse;
import com.example.coderock.service.serviceInfs.CppExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service

public class CppExecutorImpl implements CppExecutor {
    private final Logger logger = LoggerFactory.getLogger(CppExecutorImpl.class);


    public SubmissionResponse getPassedTestCases(String code, List<String> testCases, List<String> result, SubmissionResponse submissionResponse) {
        File cppFile = null;
        try {
            cppFile = writeStringToFile(code, "src/main/resources/codefiles", "cppcode.cpp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            compileCppCode(cppFile);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        int passedCase = 0;
        File finalCppFile = cppFile;
        for (int i = 0; i < testCases.size(); i++) {
            String testCase = testCases.get(i);
            try {
                if (result.get(i).equals(executeCompiledCppCodeWithInput(finalCppFile, testCase))) passedCase++;
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ;
        submissionResponse.setPassedCases(passedCase);
        submissionResponse.setFailedCases(testCases.size() - passedCase);
        submissionResponse.setTotalTestcase(testCases.size());
        submissionResponse.setCode(code);
        if (passedCase == testCases.size()) submissionResponse.setStatus(SubmissionStatus.PASS);
        else submissionResponse.setStatus(SubmissionStatus.FAIL);
        return submissionResponse;
    }

    private File writeStringToFile(String content, String parentFolder, String fileName) throws IOException {
        Path folderPath = Paths.get(parentFolder);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        Path filePath = Paths.get(parentFolder, fileName);
        Files.writeString(filePath, content);
        return filePath.toFile();
    }

    private void compileCppCode(File cppFile) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("g++", "-o", "executable", cppFile.getAbsolutePath());
        processBuilder.directory(cppFile.getParentFile());
        Process process = processBuilder.start();
        process.waitFor();
    }

    private String executeCompiledCppCodeWithInput(File cppFile, String input) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(cppFile.getParentFile().getAbsolutePath() + File.separator + ".executable");
        processBuilder.directory(cppFile.getParentFile());

        Process process = processBuilder.start();

        try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println(errorLine); // Print error stream
            }
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream());
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(input);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        StringBuilder outputBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }
        }

        int exitValue = process.waitFor();
        return outputBuilder.toString();
    }



}
