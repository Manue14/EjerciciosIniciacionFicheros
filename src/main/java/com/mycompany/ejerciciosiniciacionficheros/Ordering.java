package com.mycompany.ejerciciosiniciacionficheros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Ordering {
    public static void main(String[] args) {
        Path myPath = Path.of("sources/folder_test/prueba.txt");
        ArrayList<String> lineList = new ArrayList<String>();
        try {
            //BufferedReader myBufferedReader = Files.newBufferedReader(myPath);
            lineList.addAll(Files.readAllLines(myPath));
            Collections.sort(lineList);
            for (String line : lineList) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}