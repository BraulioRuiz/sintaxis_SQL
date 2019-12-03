/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintasissql;

import java.io.File;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JulioCaballero
 */
public class Sintaxis {

     public static void main(String[] args) throws IOException, Exception {
        String path = new File("src/sintasissql/Lexer2.flex").getAbsolutePath();
        String path2 = new File("src/sintasissql/LexerCup.flex").getAbsolutePath();
        String path3 = new File("src/sintasissql/Sintax.cup").getAbsolutePath();
        String[] rutas = {"-parser", "Sintax", path3};
        generar(path, path2, rutas);
    }

    public static void generar(String ruta1, String ruta, String[] rutas) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutas);
        Path rutaSym = Paths.get(new File("src/sintasissql/sym.java").getAbsolutePath());
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

    }

}
