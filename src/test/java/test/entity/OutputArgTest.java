package test.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputArgTest {

    @Test
    public void 出力はファイル() {
        OutputArg outputArg = new OutputArg("test.txt");
        assertTrue(outputArg.isFile());
    }
}
