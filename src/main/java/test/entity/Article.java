package test.entity;

import lombok.Value;

@Value
public class Article {

    String title;
    String body;

    public Article(String title, String body) {
        this.title = title.replace("title: ", "");
        this.body = body.replace("body: ", "");
    }

    public String formatTitle() {
        return "title: " + title;
    }

    public String formatBody() {
        return "body: " + body;
    }
}
