package com.leonardovsilva.passwordvalidator.service;

import com.leonardovsilva.passwordvalidator.domain.PasswordResult;

public interface PasswordService {

    PasswordResult validatePassword(String password);
}
