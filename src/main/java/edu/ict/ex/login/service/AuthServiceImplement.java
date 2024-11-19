package edu.ict.ex.login.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.ict.ex.login.common.CertificationNumber;
import edu.ict.ex.login.dto.requset.auth.CheckCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.EmailCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.IdCheckRequestDto;
import edu.ict.ex.login.dto.requset.auth.SignUpRequestDto;
import edu.ict.ex.login.dto.respose.auth.CheckCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.EmailCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.IdCheckResponseDto;
import edu.ict.ex.login.dto.respose.auth.ResponseDto;
import edu.ict.ex.login.dto.respose.auth.SignUpResponseDto;
import edu.ict.ex.login.entity.CertificationEntity;
import edu.ict.ex.login.entity.UserEntity;
import edu.ict.ex.login.provider.EmailProvider;
import edu.ict.ex.login.repository.CertificationRepository;
import edu.ict.ex.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;

    private final CertificationRepository certificationRepository;

    private final EmailProvider emailProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {
        
        try {
            String userId = dto.getId();
            boolean isExistId = userRepository.existsByUserId(userId);
            if (isExistId) return IdCheckResponseDto.duplicateId();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {
        
        try {

            String userId = dto.getId();
            String email = dto.getEmail();

            boolean isExistId = userRepository.existsByUserId(userId);
            if (isExistId) return EmailCertificationResponseDto.duplicateId();

            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccessed = emailProvider.sendCertificationMail(email, certificationNumber);
            if (!isSuccessed) return EmailCertificationResponseDto.mailSendFail();

            CertificationEntity certificationEntity = new CertificationEntity(userId, email, certificationNumber);
            certificationRepository.save(certificationEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return EmailCertificationResponseDto.success();

    }

    @Override
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto) {
        
        try {

            String userId = dto.getId();
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();

            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);
            if (certificationEntity == null) return CheckCertificationResponseDto.certificationFail();

            boolean isMatched = certificationEntity.getEmail().equals(email) && certificationEntity.getCertificationNumber().equals(certificationNumber);
            if (!isMatched) return CheckCertificationResponseDto.certificationFail();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return CheckCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        try {
            
            String userId = dto.getId();
            boolean isExistId = userRepository.existsByUserId(userId);
            if (isExistId) return SignUpResponseDto.duplicateId();

            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();

            CertificationEntity certificationEntity = certificationRepository.findByUserId(userId);
            boolean isMatched = 
                certificationEntity.getEmail().equals(email) &&
                certificationEntity.getCertificationNumber().equals(certificationNumber);
            if (!isMatched) return SignUpResponseDto.certificationFail();

            String password = dto. getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

            // certificationRepository.delete(certificationEntity);
            certificationRepository.deleteByUserId(userId);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.succes();
    }

    
}