package test.usecase;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.AllArgsConstructor;
import test.entity.Article;
import test.entity.InputArg;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Read {

    private final InputArg inputArg;

    public List<Article> invoke() {
        List<Article> articles = new ArrayList<>();
        if (inputArg.isUrl()) {
            try {
                // rome
                SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(inputArg.getArg())));
                for (SyndEntry entry : feed.getEntries()) {
                    articles.add(new Article(entry.getTitle(), entry.getDescription().getValue()));
                }
            } catch (FeedException | IOException e) {
                e.printStackTrace();
            }
        } else {
            Path filePath = Paths.get(inputArg.getArg());
            try {
                List<String> lines = Files.readAllLines(filePath);
                for (int i=0; i<lines.size(); i+=3) {
                    articles.add(new Article(lines.get(i), lines.get(i+1)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return articles;
    }
}
