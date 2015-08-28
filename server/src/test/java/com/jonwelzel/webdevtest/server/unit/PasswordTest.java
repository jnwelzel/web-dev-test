package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.core.security.PasswordHash;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 28/08/15.
 */
public class PasswordTest {

    private String password = "Password@123";
    private String hash;

    @Before
    public void setUp() throws InvalidKeySpecException, NoSuchAlgorithmException {
        hash = PasswordHash.createHash(password);
    }

    @Test
    public void shouldHaveDifferentHashesForSamePassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String hash2 = PasswordHash.createHash(password);

        assertThat(hash).isNotEqualTo(hash2);
    }

    @Test
    public void shouldValidatePassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        boolean validated = PasswordHash.validatePassword(password, hash);

        assertThat(validated).isTrue();
    }

    @Test
    public void shouldNotValidatePassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String wrongPassword = "WrongPassword@123";
        boolean validated = PasswordHash.validatePassword(wrongPassword, hash);

        assertThat(validated).isFalse();
    }

}
