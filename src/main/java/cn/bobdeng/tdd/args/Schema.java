package cn.bobdeng.tdd.args;


public abstract class Schema<T> {
    private final String name;
    private final T defaultValue;

    public Schema(String name, T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public T getValue(String command) {
        CommandParser commandParser = new CommandParser(command);
        return commandParser.getArgValue(this.name)
                .map(this::parseValue)
                .orElse(defaultValue);
    }

    protected abstract T parseValue(String value);
}
