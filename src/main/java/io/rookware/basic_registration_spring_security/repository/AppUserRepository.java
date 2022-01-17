package io.rookware.basic_registration_spring_security.repository;

import io.rookware.basic_registration_spring_security.model.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository {

    Optional<AppUser> findByEmail(String email);
}
