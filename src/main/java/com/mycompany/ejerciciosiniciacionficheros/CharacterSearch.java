/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciosiniciacionficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author manu
 */
public class CharacterSearch {

    public static void main(String[] args) {
        Path myPath = Path.of("sources/test.txt");
        File myFile = myPath.toFile();
        char myChar = 'e';
        ArrayList<Character> charactersList = new ArrayList<Character>();
        try {
            FileReader myReader = new FileReader(myFile);
            for (int i = 0; i < myFile.length(); i++) {
                charactersList.add((char) myReader.read());
            }
            System.out.println("El carácter " + myChar + " aparece " + Collections.frequency(charactersList, myChar));
            Collections.sort(charactersList);
            for (char c : charactersList) {
                System.out.println(c);
            }
            
            //Determinar el carácter más frecuente
            ArrayList<Character> mostFrequent = new ArrayList<Character>();
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
