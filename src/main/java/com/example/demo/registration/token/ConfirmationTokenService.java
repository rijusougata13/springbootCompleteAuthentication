package com.example.demo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokeRepository confirmationTokeRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokeRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokeRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokeRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
