package test.usecase;

import lombok.AllArgsConstructor;
import test.entity.Article;
import test.entity.OutputArg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;

@AllArgsConstructor
public class Output {

    private final List<Article> articles;
    private final OutputArg outputArg;

    public void invoke() {
        if (outputArg.isFile()) {
            Path filePath = Paths.get(outputArg.getArg());
            try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                writer.append(printFormat());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(printFormat());
        }
    }

    private String printFormat() {
        StringJoiner parent = new StringJoiner("\n\n", "", "\n");
        for (Article article : articles) {
            StringJoiner child = new StringJoiner("\n");
            child.add(article.formatTitle()).add(article.formatBody());
            parent.merge(child);
        }
        return parent.toString();
    }
}
