package test.usecase;

import org.junit.jupiter.api.Test;
import test.entity.Article;
import test.entity.ConvertArgs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertTest {

    @Test
    public void 順番どおりに処理できること() {
        Article expected1 = new Article("123456789a", "111111111122222222223333333333");
        Article expected2 = new Article("abcdefghij", "1111111111AHO222333333333344444");

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("123456789abc", "1111111111222222222233333333334444444444"));
        articles.add(new Article("abcdefghij123", "1111111111あほ22233333333334444444444"));

        ConvertArgs convertArgs = new ConvertArgs(new String[]{"cut", "convert"});

        Convert convert = new Convert(articles, convertArgs);
        List<Article> actual = convert.invoke();

        assertEquals(expected1, actual.get(0));
        assertEquals(expected2, actual.get(1));
    }

    @Test
    public void 順番入れ替わっても問題ない() {
        Article expected1 = new Article("123456789a", "111111111122222222223333333AHO");
        Article expected2 = new Article("abcdefghij", "111111111122222222223333333333");

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("123456789abc", "111111111122222222223333333あほ4444444"));
        articles.add(new Article("abcdefghij123", "111111111122222222223333333333あほ4444"));

        ConvertArgs convertArgs = new ConvertArgs(new String[]{"convert", "cut"});

        Convert convert = new Convert(articles, convertArgs);
        List<Article> actual = convert.invoke();

        assertEquals(expected1, actual.get(0));
        assertEquals(expected2, actual.get(1));
    }
}
