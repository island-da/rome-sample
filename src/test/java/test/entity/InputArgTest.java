package test.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputArgTest {

    @Test
    public void 入力はURL() {
        InputArg inputArg = new InputArg("http://aaa.b");
        assertTrue(inputArg.isUrl());
    }

    @Test
    public void httpsでもOK() {
        InputArg inputArg = new InputArg("https://aaa.b");
        assertTrue(inputArg.isUrl());
    }
}
