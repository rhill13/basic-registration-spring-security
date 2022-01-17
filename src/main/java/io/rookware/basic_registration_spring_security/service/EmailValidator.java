package io.rookware.basic_registration_spring_security.security;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return false;
    }
}
