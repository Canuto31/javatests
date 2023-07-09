package com.platzi.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    
    @Test
    public void testRepeatOnce() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void testRepeatMultipleTimes() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void testRepeatMultipleZeroTimes() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatMultipleNegativeTimes() {
        StringUtil.repeat("hola", -1);
    }
}