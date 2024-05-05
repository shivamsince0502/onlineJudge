package com.example.coderock.pojoclasses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSignUpRequest {
    private String username;
    private String password;
    private String email;
}
