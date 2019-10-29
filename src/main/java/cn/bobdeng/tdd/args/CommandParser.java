package cn.bobdeng.tdd.args;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class CommandParser {
    private String command;

    public CommandParser(String command) {
        this.command = command;
    }

    Optional<String> getArgValue(String name) {
        Iterator<String> iterator = Arrays.asList(this.command.split("\\s+")).iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (value.equals("-" + name)) {
                return getArgsValue(iterator);
            }
        }
        return Optional.empty();
    }

    private Optional<String> getArgsValue(Iterator<String> iterator) {
        if (iterator.hasNext()) {
            return Optional.ofNullable(iterator.next());
        }
        return Optional.of("");
    }
}
