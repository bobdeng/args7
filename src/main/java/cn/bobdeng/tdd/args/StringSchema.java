package cn.bobdeng.tdd.args;

public class StringSchema extends Schema<String> {


    public StringSchema(String name, String defaultValue) {
        super(name, defaultValue);
    }

    @Override
    protected String parseValue(String value) {
        return value;
    }
}
