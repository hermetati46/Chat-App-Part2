package com.poepart2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testUsernameCorrect() {
        // Test Data: "kyl_1" (contains underscore, <= 5 chars)
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexitySuccess() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexityFailure() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegistrationMessaging() {
        // Phone Success case
        String success = login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe", "+27838968976");
        assertTrue(success.contains("Username successfully captured."));
        assertTrue(success.contains("Password successfully captured."));
        assertTrue(success.contains("Phone number successfully captured."));

        // Phone failure case
        String failPhone = login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe", "0123456789");
        assertEquals("Phone number is not correctly formatted; please ensure it starts with +27 and contains 12 characters in total.", failPhone);
    }
}