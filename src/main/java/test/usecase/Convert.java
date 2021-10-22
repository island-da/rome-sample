package test.usecase;

import lombok.AllArgsConstructor;
import test.entity.Article;
import test.entity.ConvertArgs;
import test.model.CutConverter;
import test.model.ReplaceConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class Convert {

    private final List<Article> articles;
    private final ConvertArgs convertArgs;

    private static final Map<String, test.model.Converter> CONVERTER_MAP;
    static {
        CONVERTER_MAP = new HashMap<>();
        CONVERTER_MAP.put("cut", new CutConverter());
        CONVERTER_MAP.put("convert", new ReplaceConverter());
    }

    public List<Article> invoke() {
        return convert(articles, convertArgs);
    }

    private List<Article> convert(List<Article> articles, ConvertArgs convertArgs) {
        if (convertArgs.isEmpty()) {
            return articles;
        }
        return convert(CONVERTER_MAP.get(convertArgs.getArg()).convert(articles), convertArgs);
    }
}
