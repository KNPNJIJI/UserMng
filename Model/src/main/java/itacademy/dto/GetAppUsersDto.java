package itacademy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAppUsersDto {

    private String fullName;
    private String email;
    private String role;
}
