package test.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    @Test
    public void タイトルのフォーマット() {
        Article article = new Article("title", "body");
        assertEquals("title: title", article.formatTitle());
    }

    @Test
    public void ボディのフォーマット() {
        Article article = new Article("title", "body");
        assertEquals("body: body", article.formatBody());
    }
}
