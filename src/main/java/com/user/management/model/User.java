package com.user.management.model;

import com.user.management.Constant.Role;
import com.user.management.Constant.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String name;
    private String email;
    private String password;
    private Role role;
    private UserStatus userStatus;
    private double employeeId;

}
