package com.hosing.back.provider;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailProvider {

    private final JavaMailSender javaMailSender;

    private final String SUBJECT = "[임대주택 가격 서비스] 인증메일입니다.";

    public boolean sendCertificationMail(String email, String certifivationNumber) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            String htmlContent = getCertificationMessage(certifivationNumber);

            messageHelper.setTo(email);
            messageHelper.setSubject(SUBJECT);
            messageHelper.setText(htmlContent, true);

            javaMailSender.send(message); 
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
        
    }

    private String getCertificationMessage (String certifivationNumber) {

        String certificationMessage = "";
        certificationMessage += "<h1 style='text-aline: center;'>[임대주택 가격 서비스] 인증메일</h1>";
        certificationMessage += "<h3 style='text-aline: center;'>인증코드 : <strong style='font-size: 32px; letter-spacing: 8px;'>" + certifivationNumber + "</strong></h3>";
        return certificationMessage;
    }
    
}
