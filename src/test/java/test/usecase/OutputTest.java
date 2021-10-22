package test.usecase;

import org.junit.jupiter.api.Test;
import test.entity.Article;
import test.entity.OutputArg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputTest {

    @Test
    public void ファイル出力できること() throws IOException {
        String testFilePath = "src/test/resources/output_test1.txt";
        OutputArg outputArg = new OutputArg(testFilePath);

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("1のtitle", "1のbody"));
        articles.add(new Article("2のtitle", "2のbody"));

        new Output(articles, outputArg).invoke();

        Path filePath = Paths.get(testFilePath);
        assertTrue(Files.exists(filePath));

        List<String> actual = Files.readAllLines(filePath);
        assertEquals("title: 1のtitle", actual.get(0));
        assertEquals("body: 1のbody", actual.get(1));
        assertEquals("", actual.get(2));
        assertEquals("title: 2のtitle", actual.get(3));
        assertEquals("body: 2のbody", actual.get(4));
    }
}
