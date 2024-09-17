package com.mycompany.ejerciciosiniciacionficheros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.text.Collator;

public class Ordering {
    public static void main(String[] args) {
        Path myPath = Path.of("sources/folder_test/prueba.txt");
        ArrayList<String> lineList = new ArrayList<String>();
        try {
            //BufferedReader myBufferedReader = Files.newBufferedReader(myPath);
            lineList.addAll(Files.readAllLines(myPath)); //Obtenemos un ArrayList de Strings de todas las líneas del archivo
            
            order(lineList);
            
            for (String line : lineList) {
                System.out.println(line);
            }
            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static void order(ArrayList<String> lineList) {
        Locale esLocale = new Locale("es", "ES"); //Creamos el Locale del español de España
        Collator myCollator = Collator.getInstance(esLocale); //La clase Collator nos ayudará a realizar comparaciones de Strings teniendo en cuenta nuestro Locale
            
        myCollator.compare(lineList.get(0), lineList.get(1));
        //Devuelve >0 si la primera String es menor (va antes alfabéticamente) que la segunda, <0 si es mayor (va despueś) y 0 si son iguales
            
        //Bubble sort
        boolean swapped = true; //Tenemos que inicializar nuestra flag
            
        for (int i = 0; i < lineList.size() - 1 && swapped; i++) {
        //size() - 1 porque el último elemento no hay que compararlo con ningún otro, y la flag swapped para salir del bucle si tras acabar una iteración
        //no se ha realizado ningún cambio (lo que quiere decir que la lista ya está ordenada)
                
            swapped = false; //Cambiamos nuestra flag a false porque si se mantiene así hasta el final es que la lista ya está ordenada
            for (int j = 0; j < lineList.size() - 1 - i; j++) { //Segundo bucle
                if (myCollator.compare(lineList.get(j), lineList.get(j+1)) > 0) { //Comprobamos si nuestra String 'izquierda' es alfabéticamente mayor que la String 'derecha'
                    String temp = lineList.get(j); //Variable de apoyo
                    lineList.set(j, lineList.get(j+1)); //Realizamos el cambio si la condición anterior se dio
                    lineList.set(j+1, temp); //Realizamos el cambio si la condición anterior se dio
                    swapped = true; //Al haber hecho un cambio es posible que la lista no esté ordenada, así que nuestra flag pasa a ser true ya que debemos hacer otro recorrido
                }
            }
        }
    }
    
    public static void asc_case() {
        
    }
}