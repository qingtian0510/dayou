package com.evan.wj.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readFile(String path){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String str = in.readLine();
            while ((str = in.readLine()) != null) {
                if (str.trim().length() == 0)continue;
                list.add(str);
            }
        } catch (IOException e) {
        }
        return list;
    }
}
