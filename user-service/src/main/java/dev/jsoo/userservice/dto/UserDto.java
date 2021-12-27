package dev.jsoo.userservice.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;
    private String encryptedPwd;
}
