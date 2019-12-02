/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sintasissql.Tokens;
import java.util.Stack;

/**
 * FXML Controller class
 *
 * @author JulioCaballero
 */
public class SintaxisListController implements Initializable {

    @FXML
    private ListView<Label> lvCaracteres;
    @FXML
    private ListView<Label> lvCaracteresDB;
    @FXML
    private ListView<Label> lvAgrupaciones;
    @FXML
    private ListView<Label> lvReservadas;
    @FXML
    private ListView<Label> lvErrores;

    @FXML
    private TextField sentencia;

    private Stack<String> stack = new Stack<String>();
    private Stack<String> stack2 = new Stack<String>();

    @FXML
    void verificar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            limpiar();

            separar();
            //prueba(sentencia.getText());
            //analizarExpRegular();
            //reservadas(sentencia.getText());
            //caracteres(sentencia.getText());
            //revisarCaracterDB(sentencia.getText());
            //revisarAgrupacion(sentencia.getText());
        }
    }

    private ObservableList<Label> caracteres;
    private ObservableList<Label> caracteresDB;
    private ObservableList<Label> agrupaciones;
    private ObservableList<Label> reservadas;
    private ObservableList<Label> errores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        caracteres = FXCollections.observableArrayList();
        caracteresDB = FXCollections.observableArrayList();
        agrupaciones = FXCollections.observableArrayList();
        reservadas = FXCollections.observableArrayList();
        errores = FXCollections.observableArrayList();
        lvCaracteres.setItems(caracteres);
        lvCaracteresDB.setItems(caracteresDB);
        lvAgrupaciones.setItems(agrupaciones);
        lvReservadas.setItems(reservadas);
        lvErrores.setItems(errores);
        sentencia.setText("ALTER TABLE nombre ADD nombre [ FIRST nombre ]");
        limpiar();
    }

    private void limpiar() {
        lvCaracteres.getItems().clear();
        lvCaracteres.refresh();
        lvCaracteresDB.getItems().clear();
        lvCaracteresDB.refresh();
        lvAgrupaciones.getItems().clear();
        lvAgrupaciones.refresh();
        lvReservadas.getItems().clear();
        lvReservadas.refresh();
        lvErrores.getItems().clear();
        lvErrores.refresh();
    }

    private boolean revisarCaracterDB(String sentencia) {
        //System.out.println(sentencia);       
        boolean valor = false;
        Pattern text = Pattern.compile("[a-z][a-z|_|-|0-9]*");

        Matcher matcher = text.matcher(sentencia);
        while (matcher.find()) {
            caracteresDB.add(new Label(matcher.group()));
            valor = true;
        }

        return valor;
        // clLexico.setCellValueFactory(cellData -> 
        //     new ReadOnlyStringWrapper(cellData.getValue()));
    }

    private boolean revisarAgrupacion(String sentencia) {
        //System.out.println(sentencia);       
        boolean valor = false;
        Pattern text = Pattern.compile("\\[[^\\[]*\\]");

        Matcher matcher = text.matcher(sentencia);
        while (matcher.find()) {
            agrupaciones.add(new Label(matcher.group()));
            valor = true;
        }
        return valor;
    }

    private boolean reservadas(String sentencia) {
        boolean valor = false;
        Pattern expresion = Pattern.compile("(TABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX)");

        //[A-Z|a-z][a-z|A-Z|_]*
        Matcher matcher = expresion.matcher(sentencia);

        while (matcher.find()) {
            reservadas.add(new Label(matcher.group()));
            valor = true;
        }
        return valor;
    }

    private boolean caracteres(String sentencia) {
        boolean valor = false;
        Pattern expresion = Pattern.compile("[A-Z|a-z][a-z|_|0-9|A-Z]*[^\\WTABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX]");

        Matcher matcher = expresion.matcher(sentencia);
        while (matcher.find()) {
            caracteres.add(new Label(matcher.group()));
            valor = true;
        }
        return valor;
    }

    private void errores(String sentencia) {
        Pattern expresion = Pattern.compile("");

        Matcher matcher = expresion.matcher(sentencia);
        while (matcher.find()) {
            errores.add(new Label(matcher.group()));
        }
    }

    private void separar() {
        String[] data = sentencia.getText().split(" ");
        String lexer = "";
        for (String dato : data) {
            lexer += analizarExpRegular(dato);
        }

        System.out.println("Datos lexico: " + lexer);

        String[] lexers = lexer.split(" ");

        String error = "";

        if (pilagramatica1(lexers, error)) {
            System.out.println("La sintaxis es valida: " + error);
        } else {
            System.out.println("La sintaxis es invalida: " + error);
        }
    }

    private String analizarExpRegular(String data) {
        try {
            File Archivo = new File("archivo.txt");
            PrintWriter escribir;
            escribir = new PrintWriter(Archivo);
            escribir.print(data);
            escribir.close();
        } catch (FileNotFoundException ex) {

        }
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexico lexer = new Lexico(lector);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN";
                    //sentencia.setText(resultado);
                    return "";
                }

                boolean caracter = false;
                boolean caracterdb = false;

                switch (tokens) {
                    case Caracteres:
                        boolean mayuscula = false;

                        char[] datos = lexer.yytext().toCharArray();
                        for (int i = 0; i < datos.length; i++) {
                            if (Character.isUpperCase(datos[i])) {
                                mayuscula = true;
                            }
                        }
                        if (lexer.yytext().equals(data)) {
                            if (!mayuscula) {
                                caracteresDB.add(new Label(lexer.yytext()));
                                caracterdb = true;
                            }
                            caracteres.add(new Label(lexer.yytext()));
                            caracter = true;
                        } else {
                            errores.add(new Label(data));
                        }

                        break;
                    case CaracteresTable:
                        if (lexer.yytext().equals(data)) {
                            caracteresDB.add(new Label(lexer.yytext()));
                            caracterdb = true;
                        } else {
                            errores.add(new Label(data));
                        }
                        break;
                    case Agrupaciones:
                        if (lexer.yytext().equals(data)) {
                            agrupaciones.add(new Label(lexer.yytext()));

                        } else {
                            errores.add(new Label(data));
                        }
                        break;
                    case Reservadas:
                        if (lexer.yytext().equals(data)) {
                            reservadas.add(new Label(lexer.yytext()));

                        } else {
                            errores.add(new Label(data));
                        }
                        break;
                    case ERROR:
                        if (lexer.yytext().equals(data)) {
                            errores.add(new Label(data));
                        } else {
                            errores.add(new Label(data));
                        }
                        break;
                    default:
                        break;
                }

                if (caracterdb && caracter) {
                    return "*Caracter ";
                } else if (caracterdb) {
                    return "TituloCaracter ";
                } else if (caracter) {
                    return "Caracter ";
                } else {
                    return data + " ";
                }
            }
        } catch (IOException ex) {
        }
        return "";
    }

    private void prueba(String text) {
        String[] data = text.split(" ");

        for (String dato : data) {
            if (reservadas(dato)) {

            } else if (caracteres(dato)) {

            } else if (revisarCaracterDB(dato)) {

            } else if (revisarAgrupacion(dato)) {

            }
        }

    }

    private boolean pilagramatica1(String[] data, String error) {
        stack.push("ALTER");
        stack.push("TABLE");
        stack.push("TituloCaracter");
        stack.push("ADD");
        stack.push("Caracter");
        stack.push("[");
        stack.push("FIRST|AFTER");
        stack.push("Caracter");
        stack.push("]");

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        int dato = 1;
        stack2.pop();
        stack2.pop();
        
        while (!stack2.isEmpty() && dato < data.length) {
          
            System.out.println("Errorr : " + stack2.peek());
            
             
            if (!stack2.peek().equals(data[++dato])) {
                if (dato == 2 && data[2].equals("*Caracter")) {
                } else if (dato == 4 && (data[4]).equals("*Caracter")) {
                } else if (dato == 6 && ((data[6]).equals("FIRST") || (data[6]).equals("AFTER"))) {
                } else if (dato == 7 && data[7].equals("*Caracter")) {
                } else {
                    return false;
                }
            }

            stack2.pop();

        }

        return stack2.isEmpty();

    }

    private void ejecutargramatica(String[] data) {
        while (!stack2.isEmpty()) {

        }
    }

}
