package cn.bobdeng.tdd.args;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;
import org.junit.Before;
import sun.jvm.hotspot.oops.OopField;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {

    @Test
    public void should_return_false_when_empty() {
        BooleanSchema schema = new BooleanSchema("d", false);
        assertThat(schema.getValue(""), is(false));
    }

    @Test
    public void should_return_default_int_value_when_empty() {
        IntegerSchema schema = new IntegerSchema("p", 8080);
        assertThat(schema.getValue(""), is(8080));
    }

    @Test
    public void should_return_default_string_value_when_empty() {
        StringSchema schema = new StringSchema("-l", "/usr/local");
        assertThat(schema.getValue(""), is("/usr/local"));
    }

    @Test
    public void should_return_true_when_exist() {
        BooleanSchema schema = new BooleanSchema("d", false);
        assertThat(schema.getValue("-d"), is(true));
    }

    @Test
    public void should_return_int_when_exist() {
        IntegerSchema schema = new IntegerSchema("p", 8080);
        assertThat(schema.getValue("-p 80"), is(80));
    }

    @Test
    public void should_return_string_when_exist() {
        assertThat(new StringSchema("l", "/var/lib").getValue("-l /usr/local -d -p 80"), is("/usr/local"));
        assertThat(new IntegerSchema("p", 8080).getValue("-l /usr/local -d -p 80"), is(80));
        assertThat(new BooleanSchema("d", false).getValue("-l /usr/local -d -p 80"), is(true));
    }
}
