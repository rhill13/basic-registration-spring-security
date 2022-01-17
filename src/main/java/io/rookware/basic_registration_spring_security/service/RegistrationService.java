package io.rookware.basic_registration_spring_security.service;

import io.rookware.basic_registration_spring_security.dto.RegistrationRequest;
import io.rookware.basic_registration_spring_security.model.AppUser;
import io.rookware.basic_registration_spring_security.model.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );

    }
}
