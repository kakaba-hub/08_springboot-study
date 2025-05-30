package com.kyungbae.rest.section03.validation;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
    private int no;

    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;

    @NotNull(message = "비밀번호는 반드시 입력되어야 합니다.")
    @Size(min=5, message = "비밀번호는 5자 이상 이여야 합니다.")
    @Size(max=20, message = "비밀번호는 20자 이하 여야 합니다.")
    private String pwd;

    @NotBlank(message = "이름은 반드시 입력되어야 합니다.")
    @Size(min=2, message = "이름은 2글자 이상이여야 합니다.")
    private String name;
    private LocalDateTime enrollDate;
}
