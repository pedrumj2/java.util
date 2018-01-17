package com.pedrumjalali.util;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Config {
    private HashMap<String, String> keyValues;
    public boolean success = false;
    public Config(String __fileName) {
        try{
            BufferedReader _is = getFileInputStream(__fileName);
            List<String> _lines = getLines(_is);
            keyValues = getKeyValues(_lines);
            success =true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public Config(String __fileName, String __directory)  {
        BufferedReader _is = null;
        try {
            _is = getFileInputStream(__fileName, __directory);
            List<String> _lines = getLines(_is);
            keyValues = getKeyValues(_lines);
            success = true;
        } catch (Exception __e) {
            __e.printStackTrace();
        }
    }

    public String getValue(String __key){
        return keyValues.get(__key);
    }

    private BufferedReader getFileInputStream(String __fileName){
        ClassLoader _classloader = Thread.currentThread().getContextClassLoader();
        BufferedReader _is = new BufferedReader( new InputStreamReader(_classloader.getResourceAsStream(__fileName)));
        return _is;
    }

    private BufferedReader getFileInputStream(String __fileName, String __directory) throws FileNotFoundException {

        BufferedReader _is = new BufferedReader(
                new InputStreamReader(new FileInputStream(__directory + "/"  + __fileName)));
        return _is;
    }

    private HashMap<String, String> getKeyValues(List<String> __input){
        Pair<String, String> _linePair;
        HashMap<String, String> _output = new HashMap<String, String>();
        for (int i =0 ; i < __input.size();i++){
            _linePair = getKeyValue(__input.get(i));
            if (_linePair != null){
                _output.put(_linePair.getKey(), _linePair.getValue());
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
