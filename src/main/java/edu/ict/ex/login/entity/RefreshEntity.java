package edu.ict.ex.login.entity;

import edu.ict.ex.login.entity.RefreshEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshEntity {
	
	private Long id;
    private String accessToken;
    private String refreshToken;
    private String username;
    private Long userId;
    private String role;
    
}
