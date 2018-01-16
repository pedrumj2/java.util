package test.unit.com.pedrumjalali.util;

import com.pedrumjalali.util.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void firstRow() throws IOException {
        Config _config = new Config("config.txt");
        assertEquals(_config.getValue("key1"), "value1");
    }

    @Test
    public void nullRow() throws IOException {
        Config _config = new Config("config.txt");
        assertEquals(_config.getValue("key3"), null);
    }

    @Test
    public void lastRow() throws IOException {
        Config _config = new Config("config.txt");
        assertEquals(_config.getValue("key2"), "value2");
    }




}