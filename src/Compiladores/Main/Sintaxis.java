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
import java.io.*;
import java_cup.runtime.*;


/**
 *
 * @author JulioCaballero
 */
public class Sintaxis {

     public static void main(String[] args) throws Exception {
        String path = new File("src/Compiladores/Main/Lexer.flex").getAbsolutePath();
       // String path2 = new File("src/Compiladores/Main/LexerCup.flex").getAbsolutePath();
      //  String path3 = new File("src/Compiladores/Main/Sintax.cup").getAbsolutePath();
      //  String[] rutas = {"-parser", "Sintax",new File("src/sintasissql/Sintax.cup").getAbsolutePath()};
       // generar(path, path2, rutas);
       
       generar(path);
    }

    public static void generar(String ruta1) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        //archivo = new File(ruta);
        //JFlex.Main.generate(archivo);
        //java_cup.Main.main(rutas);
        
       /* Path rutaSym = Paths.get(new File("src/sintasissql/sym.java").getAbsolutePath());
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(Paths.get(new File("sym.java").getAbsolutePath()),
                Paths.get(new File("src/sintasissql/sym.java").getAbsolutePath()));

        Path rutaSin = Paths.get(new File("src/sintasissql/Sintax.java").getAbsolutePath());
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(Paths.get(new File("Sintax.java").getAbsolutePath()),
                Paths.get(new File("src/sintasissql/Sintax.java").getAbsolutePath()));
        */
        }

}
