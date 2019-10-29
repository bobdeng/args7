package cn.bobdeng.tdd.args;

public class IntegerSchema extends Schema<Integer> {

    public IntegerSchema(String name, int defaultValue) {
        super(name, defaultValue);
    }

    @Override
    protected Integer parseValue(String value) {
        return Integer.parseInt(value);
    }
}
