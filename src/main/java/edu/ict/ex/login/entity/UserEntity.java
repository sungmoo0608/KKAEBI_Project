package edu.ict.ex.login.entity;

import edu.ict.ex.login.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserEntity {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String role;

}
