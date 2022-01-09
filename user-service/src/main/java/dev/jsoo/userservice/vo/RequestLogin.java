package dev.jsoo.userservice.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RequestLogin {
    @NotNull(message = "Email connot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equals or grater then 8 characters")
    private String password;
}
