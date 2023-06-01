package com.example.ecommerceFinalDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int user_id;

    @NotNull
    private String user_name;
  @Email(message = "Email address is not valid !!")
    private String email;
    @NotNull
    @Size(min = 3,max = 8,message = "Password must be of min 3 to 8 characters !!")
    private String pass;

}
