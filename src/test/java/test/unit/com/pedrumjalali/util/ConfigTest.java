package test.unit.com.pedrumjalali.util;

import com.pedrumjalali.util.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void test() throws IOException {
        Config _config = new Config("config.txt");
    }

}