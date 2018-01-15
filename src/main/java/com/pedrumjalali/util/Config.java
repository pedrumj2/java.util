package com.pedrumjalali.util;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Config {
    public Config(String __fileName) throws IOException {
        BufferedReader _is = getFileInputStream(__fileName);
        List<String> _lines = getLines(_is);
        List<Pair<String, String>> _keyValues = getKeyValues(_lines);

        int x = 3;
    }
    private BufferedReader getFileInputStream(String __fileName){
        ClassLoader _classloader = Thread.currentThread().getContextClassLoader();
        BufferedReader _is = new BufferedReader( new InputStreamReader(_classloader.getResourceAsStream(__fileName)));
        return _is;
    }

    private List<Pair<String, String>> getKeyValues(List<String> __input){
        Pair<String, String> _linePair;
        List<Pair<String, String>> _output = new ArrayList<Pair<String, String>>();
        for (int i =0 ; i < __input.size();i++){
            _linePair = getKeyValue(__input.get(i));
            if (_linePair != null){
                _output.add(_linePair);
            }
        }
        return _output;
    }

    private Pair<String, String> getKeyValue(String __input){
        String[] _splits = __input.split(":");
        String _key;
        String _value;
        if (_splits.length ==2 ){
            _key = _splits[0].trim();
            _value = _splits[1].trim();
            return (Pair<String, String>) new Pair(_key, _value);
        }
        else{
            return null;
        }

    }
    private List<String> getLines(BufferedReader __inputStream) throws IOException {
        String _line;
        List<String> _output =new ArrayList<String>();
        while ((_line = __inputStream.readLine()) !=null){
            _output.add(_line);
        }
        return _output;
    }
}
