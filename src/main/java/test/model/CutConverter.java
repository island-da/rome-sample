package test.model;

import org.apache.commons.lang3.StringUtils;
import test.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class CutConverter implements Converter {

    @Override
    public List<Article> convert(List<Article> articles) {
        List<Article> convertedArticles = new ArrayList<>();
        for (Article article : articles) {
            convertedArticles.add(
                    new Article(
                            StringUtils.substring(article.getTitle(), 0, 10),
                            StringUtils.substring(article.getBody(), 0, 30)
                    )
            );
        }
        return convertedArticles;
    }
}
