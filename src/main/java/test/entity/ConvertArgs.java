package test.entity;

import lombok.EqualsAndHashCode;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;

@EqualsAndHashCode
public class ConvertArgs {

    private final LinkedList<String> args;

    public ConvertArgs(String[] args) {
        if (args != null) {
            this.args = new LinkedList<>(Arrays.asList(args));
        } else {
            this.args = new LinkedList<>();
        }
    }

    public String getArg() {
        return CollectionUtils.isEmpty(args) ? "" : args.pop();
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(args);
    }
}
