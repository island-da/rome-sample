package test.model;

import org.apache.commons.lang3.StringUtils;
import test.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ReplaceConverter implements Converter {

    @Override
    public List<Article> convert(List<Article> articles) {
        List<Article> convertedArticles = new ArrayList<>();
        for (Article article : articles) {
            convertedArticles.add(
                    new Article(
                            article.getTitle(),
                            StringUtils.replace(article.getBody(), "あほ", "AHO")
                    )
            );
        }
        return convertedArticles;
    }
}
