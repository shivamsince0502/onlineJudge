package com.example.coderock.model;

import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.Text;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "problem")
@Data
public class Problem {
    @Id
    private ObjectId id;
    private Long problemNo;
    private String problemTitle;
    private String description;
    @DBRef
    private List<Tag> tag;
    private List<String> sampleCases;
    private List<String> hiddenCases;
    private List<String> result;

}
