package test.entity;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsFactory {

    public static Options factory() {
        Options options = new Options();

        options.addOption(
                Option.builder("i")
                        .argName("input")
                        .numberOfArgs(1)
                        .required()
                        .desc("入力")
                        .build()
        );

        options.addOption(
                Option.builder("c")
                        .argName("convert")
                        .hasArgs()
                        .valueSeparator(',')
                        .desc("変換")
                        .build()
        );

        options.addOption(
                Option.builder("o")
                        .argName("output")
                        .numberOfArgs(1)
                        .required(false)
                        .desc("出力")
                        .build()
        );

        return options;
    }
}
