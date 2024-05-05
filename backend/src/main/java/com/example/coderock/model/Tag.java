package com.example.coderock.model;

import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "tag")
@Data
public class Tag {
    @Id
    private ObjectId id;
    private String tagName;
}
