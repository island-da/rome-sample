package test.entity;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
public class InputArg {

    String arg;

    public boolean isUrl() {
        return StringUtils.startsWith(arg, "http");
    }
}
