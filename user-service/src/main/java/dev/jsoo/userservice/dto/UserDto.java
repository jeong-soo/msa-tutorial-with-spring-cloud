package dev.jsoo.userservice.dto;

import com.sun.istack.NotNull;
import dev.jsoo.userservice.vo.ResponseOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDto {
    private String email;
    private String name;
    private String password;
    private String id;
    private Date createAt;
    private String encryptedPassword;

    private List<ResponseOrder> orders;
}
