package test;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import test.entity.Article;
import test.entity.ConvertArgs;
import test.entity.InputArg;
import test.entity.OutputArg;
import test.entity.OptionsFactory;
import test.usecase.Convert;
import test.usecase.Output;
import test.usecase.Read;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Options options = OptionsFactory.factory();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine command = parser.parse(options, args);

            InputArg inputArg = new InputArg(command.getOptionValue("i"));
            List<Article> articles = new Read(inputArg).invoke();

            ConvertArgs convertArgs = new ConvertArgs(command.getOptionValues("c"));
            List<Article> convertedArticles = new Convert(articles, convertArgs).invoke();

            OutputArg outputArg = new OutputArg(command.getOptionValue("o"));
            new Output(convertedArticles, outputArg).invoke();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
