package com.company.api.services.impl;

import com.company.api.dto.UserEntityDto;
import com.company.api.exception.UserAlreadyExistsException;
import com.company.api.mapper.UserEntityMapper;
import com.company.api.models.UserEntity;
import com.company.api.models.VerificationToken;
import com.company.api.repositories.UserRepository;
import com.company.api.services.UserService;
import com.company.api.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final VerificationService verificationService;
    private final MailSenderService mailSenderService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           VerificationService verificationService,
                           MailSenderService mailSenderService,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.verificationService = verificationService;
        this.mailSenderService = mailSenderService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntityDto createUser(UserEntityDto userDto) {
        UserEntity user = UserEntityMapper.mapToEntity(userDto);
        UserEntity newUser = userRepository.save(user);
        return UserEntityMapper.mapToDto(newUser);
    }

    @Transactional
    @Override
    public void registerUser(UserEntityDto userDto) {
        if(userDto.getEmail() != null && userRepository.findByEmailOrUsername(userDto.getEmail(), userDto.getUsername()).isPresent())
                throw new UserAlreadyExistsException("This email or username is already registered.");

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity newUser = userRepository.save(UserEntityMapper.mapToEntity(userDto));
        VerificationToken newToken = verificationService.createVerification(newUser);
        mailSenderService.sendMail(newUser.getEmail(), "Verification Link",
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() +"/verify?token=" + newToken.getToken());
    }

    @Transactional
    @Override
    public void verifyUserByToken(String token) {
        VerificationToken verificationToken = verificationService.verifyToken(token);
        UserEntity verifiedUser = verificationToken.getUser();
        verifiedUser.setEnabled(true);
        userRepository.save(verifiedUser);
    }
}
