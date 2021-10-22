package test.model;

import org.junit.jupiter.api.Test;
import test.entity.Article;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutConverterTest {

    @Test
    public void カットできていること() {
        Article expected = new Article("123456789a", "111111111122222222223333333333");

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("123456789abc", "1111111111222222222233333333334444444444"));

        Converter cutConverter = new CutConverter();
        List<Article> actual = cutConverter.convert(articles);

        assertEquals(expected, actual.get(0));
    }

    @Test
    public void 短い場合はそのまま() {
        Article expected = new Article("12345678", "11111111112222222222");

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("12345678", "11111111112222222222"));

        Converter cutConverter = new CutConverter();
        List<Article> actual = cutConverter.convert(articles);

        assertEquals(expected, actual.get(0));
    }
}
