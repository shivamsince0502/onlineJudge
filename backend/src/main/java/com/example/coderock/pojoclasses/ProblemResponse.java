package com.example.coderock.pojoclasses;

import com.example.coderock.model.Tag;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProblemResponse {
    private Long problemNo;
    private String problemTitle;
    private String description;
    @DBRef
    private List<Tag> tag;
    private List<String> sampleCases;
    private List<String> hiddenCases;
    private List<String> result;
}
