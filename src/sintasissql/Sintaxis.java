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

/**
 *
 * @author JulioCaballero
 */
public class Sintaxis {
    
    public static void main(String[] args) throws IOException, Exception {
        String path = new File("src/sintasissql/Lexer.flex").getAbsolutePath();
        generar(path);
    }

    public static void generar(String path) throws IOException, Exception {
        File file = new File(path);
        JFlex.Main.generate(file);
    }

} 
