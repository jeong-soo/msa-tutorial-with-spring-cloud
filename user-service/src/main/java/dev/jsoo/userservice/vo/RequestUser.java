package dev.jsoo.userservice.vo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RequestUser {
    @NotNull
    @Size(min = 2)
    @Email
    private String email;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String pwd;
}
