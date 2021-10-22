package test.entity;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
public class OutputArg {

    String arg;

    public boolean isFile() {
        return StringUtils.isNotBlank(arg);
    }
}
