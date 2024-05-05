package com.example.coderock.pojoclasses;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProblemRequest {
    private String problemDescription;
    private Long problemNo;
    private String problemTitle;
    private String username;
    private List<TagRequest> tags;
    private List<String> sampleTestCase;
    private List<String> hiddenTestCase;
    private List<String> result;

}
