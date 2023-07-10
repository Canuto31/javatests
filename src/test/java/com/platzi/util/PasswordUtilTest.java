package com.platzi.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.platzi.util.PasswordUtil.SecurityLevel.*;


public class PasswordUtilTest {
    
    @Test
    public void weakWhenHasLessThan8LettersTest() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }
    
    @Test
    public void weakWhenHasOnlyLettersTest() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abdcefgh"));
    }

    @Test
    public void mediumWhenHasLettersAndNumbersTest() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abdc1234"));
    }

    @Test
    public void StrongWhenHasLettersNumbersAndSymbolsTest() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abdc1234&"));
    }
}
