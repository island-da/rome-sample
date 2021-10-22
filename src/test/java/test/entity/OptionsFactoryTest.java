package test.entity;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsFactoryTest {

    @Test
    public void iは必須である() {
        String[] args = new String[]{""};
        Options options = OptionsFactory.factory();
        CommandLineParser parser = new DefaultParser();
        Assertions.assertThrows(MissingOptionException.class, () -> parser.parse(options, args));
    }

    @Test
    public void cとoは必須ではない() {
        String[] args = new String[]{"-i", "test.txt"};
        Options options = OptionsFactory.factory();
        CommandLineParser parser = new DefaultParser();
        Assertions.assertDoesNotThrow(() -> parser.parse(options, args));
    }

    @Test
    public void cはカンマ区切り() throws ParseException {
        String[] args = new String[]{"-i", "test.txt", "-c", "a,b"};
        Options options = OptionsFactory.factory();
        CommandLineParser parser = new DefaultParser();
        CommandLine command = parser.parse(options, args);

        String[] actual = command.getOptionValues("c");

        assertEquals("a", actual[0]);
        assertEquals("b", actual[1]);
    }

    @Test
    public void cはカンマなくてもOK() throws ParseException {
        String[] args = new String[]{"-i", "test.txt", "-c", "a"};
        Options options = OptionsFactory.factory();
        CommandLineParser parser = new DefaultParser();
        CommandLine command = parser.parse(options, args);

        String[] actual = command.getOptionValues("c");

        assertEquals("a", actual[0]);
    }
}
