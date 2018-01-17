package com.pedrumjalali.util.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private BufferedWriter bufferedWriter;
    private boolean success = true;
    public Writer(String __path){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(__path));

        } catch (IOException __e) {
            __e.printStackTrace();
            success = false;
        }
    }

    public boolean write(String __text){
        if (!success){
            return false;
        }
        try {
            bufferedWriter.write(__text);
        } catch (IOException __e)
        {
            __e.printStackTrace();
            success = false;
        }
        return false;
    }
    public void close(){
        try {
            bufferedWriter.close();
        } catch (IOException __e) {
            __e.printStackTrace();
        }
    }
}
