package com.leonardovsilva.passwordvalidator.api.controller;

import com.leonardovsilva.passwordvalidator.api.input.PasswordRequest;
import com.leonardovsilva.passwordvalidator.api.output.PasswordResponse;
import com.leonardovsilva.passwordvalidator.domain.PasswordResult;
import com.leonardovsilva.passwordvalidator.service.PasswordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/password")
public class PasswordController {

    private final PasswordService passwordService;

    @PostMapping
    public ResponseEntity<PasswordResponse> create(@RequestBody @Valid PasswordRequest dto) {
        PasswordResult result = passwordService.validatePassword(dto.getPassword());

        var response = new PasswordResponse().toPasswordResponse(result);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
