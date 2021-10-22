package test.model;

import org.junit.jupiter.api.Test;
import test.entity.Article;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceConverterTest {

    @Test
    public void 置換できていること() {
        Article expected = new Article("aaaaaあほbbbbb", "AHOaaaaaAHObbbbbAHO");

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("aaaaaあほbbbbb", "あほaaaaaあほbbbbbあほ"));

        Converter replaceConverter = new ReplaceConverter();
        List<Article> actual = replaceConverter.convert(articles);

        assertEquals(expected, actual.get(0));
    }
}
