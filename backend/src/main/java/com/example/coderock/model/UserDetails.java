package com.example.coderock.model;

import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "userdetails")
@Data
public class UserDetails {
    @Id
    @Indexed(unique = true)
    private ObjectId id;
    @DBRef
    private User user;
    private String firstName;
    private String lastName;
    private String mobileNumber;


}
