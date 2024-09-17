/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciosiniciacionficheros;
import java.io.File;
/**
 *
 * @author manu
 */
public class SimpleLs {

    public static void main(String[] args) {
        File myFolder = new File("sources");
        if (myFolder.exists()) {
            for (File element: myFolder.listFiles()) {

                StringBuilder properties = new StringBuilder("----");

                if (element.isDirectory()) {
                    properties.replace(0, 1, "d");
                }

                if (element.canRead()) {
                    properties.replace(1, 2, "r");
                }

                if (element.canWrite()) {
                    properties.replace(2, 3, "w");
                }

                if (element.canExecute()) {
                    properties.replace(3, 4, "x");
                }
                System.out.println(properties + " " + element.getName());
            }
        }
    }
}
