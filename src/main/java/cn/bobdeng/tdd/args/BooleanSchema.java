package cn.bobdeng.tdd.args;

public class BooleanSchema extends Schema<Boolean>{

    public BooleanSchema(String name, Boolean defaultValue) {
        super(name, defaultValue);
    }

    @Override
    protected Boolean parseValue(String value) {
        return true;
    }
}
