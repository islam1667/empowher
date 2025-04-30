package com.company.api.services;

import com.company.api.models.UserEntity;
import com.company.api.models.VerificationToken;

public interface VerificationService {
    VerificationToken createVerification(UserEntity userEntity);

    VerificationToken verifyToken(String token);

}
