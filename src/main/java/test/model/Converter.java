package test.model;

import test.entity.Article;

import java.util.List;

public interface Converter {
    List<Article> convert(List<Article> articles);
}
