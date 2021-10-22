package test.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertArgsTest {

    @Test
    public void 任意の文字が取れること() {
        ConvertArgs convertArgs = new ConvertArgs(new String[]{"a", "b", "c"});
        assertEquals("a", convertArgs.getArg());
        assertEquals("b", convertArgs.getArg());
        assertEquals("c", convertArgs.getArg());
    }

    @Test
    public void ない場合は空文字() {
        ConvertArgs convertArgs = new ConvertArgs(null);
        assertEquals("", convertArgs.getArg());
    }

    @Test
    public void 空である() {
        ConvertArgs convertArgs = new ConvertArgs(null);
        assertTrue(convertArgs.isEmpty());
    }

    @Test
    public void 空ではない() {
        ConvertArgs convertArgs = new ConvertArgs(new String[]{"a", "b", "c"});
        assertFalse(convertArgs.isEmpty());
    }
}
