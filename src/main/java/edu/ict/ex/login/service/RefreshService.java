package edu.ict.ex.login.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.ict.ex.login.entity.RefreshEntity;
import edu.ict.ex.login.mapper.RefreshMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshService {
	
	  private final RefreshMapper refreshMapper;

	    public Optional<RefreshEntity> getRefreshEntityByAccessToken(String accessToken) {
	        return refreshMapper.findByAccessToken(accessToken);
	    }

	    public Optional<RefreshEntity> getRefreshEntityByRefreshToken(String refreshToken) {
	        return refreshMapper.findByRefreshToken(refreshToken);
	    }

	    public void deleteByRefreshToken(String refreshToken) {
	        refreshMapper.deleteByRefreshToken(refreshToken);
	    }

}
