package com.company.api.services.impl;

import com.company.api.exception.UserAlreadyExistsException;
import com.company.api.exception.VerificationTokenExpiredException;
import com.company.api.exception.VerificationTokenNotFoundException;
import com.company.api.models.UserEntity;
import com.company.api.models.VerificationToken;
import com.company.api.repositories.VerificationRepository;
import com.company.api.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    VerificationRepository verificationRepository;

    @Autowired
    public VerificationServiceImpl(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    @Override
    public VerificationToken createVerification(UserEntity user) {
        VerificationToken verificationToken = new VerificationToken(user);
        return verificationRepository.save(verificationToken);
    }

    @Override
    public VerificationToken verifyToken(String token) {
        VerificationToken verificationToken = verificationRepository.findByToken(token).orElseThrow(()-> new VerificationTokenNotFoundException("Token not found"));
        if(!verificationToken.isExpired()) throw new VerificationTokenExpiredException("Verification token Expired");
        if(verificationToken.getVerified()) throw new UserAlreadyExistsException("User Already Verified");

        verificationToken.setVerified(true);
        verificationRepository.save(verificationToken);
        return verificationToken;
    }
}
