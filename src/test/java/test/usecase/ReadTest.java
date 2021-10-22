package test.usecase;

import org.junit.jupiter.api.Test;
import test.entity.Article;
import test.entity.InputArg;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadTest {

    @Test
    public void ファイルを読み込めること() {
        String testFilePath = "src/test/resources/input_test1.txt";
        InputArg inputArg = new InputArg(testFilePath);

        List<Article> actual = new Read(inputArg).invoke();

        assertEquals("1のtitle", actual.get(0).getTitle());
        assertEquals("1のbody", actual.get(0).getBody());
        assertEquals("2のtitle", actual.get(1).getTitle());
        assertEquals("2のbody", actual.get(1).getBody());
    }
}
