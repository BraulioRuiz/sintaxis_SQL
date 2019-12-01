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

        for (String dato : data) {
            analizarExpRegular(dato);
        }
    }

    private void analizarExpRegular(String data) {
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
                    return;
                }

                int paso = 0;
                switch (tokens) {
                    case Caracteres:
                        paso++;
                        boolean mayuscula = false;

                        char[] datos = lexer.yytext().toCharArray();
                        for (int i = 0; i < datos.length; i++) {
                            if (Character.isUpperCase(datos[i])) {
                                mayuscula = true;
                            }
                        }

                        if (!mayuscula) {
                            caracteresDB.add(new Label(lexer.yytext()));
                        }
                        caracteres.add(new Label(lexer.yytext()));
                        break;
                    case CaracteresTable:
                        paso++;
                        caracteresDB.add(new Label(lexer.yytext()));
                        break;
                    case Agrupaciones:
                        paso++;
                        agrupaciones.add(new Label(lexer.yytext()));
                        break;
                    case Reservadas:
                        paso++;
                        reservadas.add(new Label(lexer.yytext()));
                        break;
                    case ERROR:
                        paso++;
                        errores.add(new Label(lexer.yytext()));
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException ex) {
        }
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

}
