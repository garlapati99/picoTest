package com.ocbc.javaexamples;

public class TestString {


    private final String bcd;
    private final String abc;

    @Override
    public String toString() {
        return "test " + abc + " test2 " + bcd;
    }

    public TestString(String abc, String bcd) {
        this.abc = abc;
        this.bcd = bcd;
    }
}


