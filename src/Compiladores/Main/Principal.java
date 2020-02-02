/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiladores.Main;

import sintasissql.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "E:/Documentos/NetBeansProjects/sintasissql/src/codigo/Lexer2.flex";
        String ruta2 = "E:/Documentos/NetBeansProjects/sintasissql/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "E:/Documentos/NetBeansProjects/sintasissql/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
     
        Path rutaSin = Paths.get("E:/Documentos/NetBeansProjects/sintasissql/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("E:/Documentos/NetBeansProjects/sintasissql/Sintax.java"), 
                Paths.get("E:/Documentos/NetBeansProjects/sintasissql/src/codigo/Sintax.java")
        );
    }
}