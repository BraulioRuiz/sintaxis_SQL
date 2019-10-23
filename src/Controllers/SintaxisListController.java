/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
            reservadas(sentencia.getText());
            caracteres(sentencia.getText());
            revisarCaracterDB(sentencia.getText());
            revisarAgrupacion(sentencia.getText());
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

    private void revisarCaracterDB(String sentencia) {
        //System.out.println(sentencia);       

        Pattern text = Pattern.compile("[a-z][a-z|_|-|0-9]*");

        Matcher matcher = text.matcher(sentencia);
        while (matcher.find()) {
            caracteresDB.add(new Label(matcher.group()));
        }
        // clLexico.setCellValueFactory(cellData -> 
        //     new ReadOnlyStringWrapper(cellData.getValue()));

    }

    private void revisarAgrupacion(String sentencia) {
        //System.out.println(sentencia);       

        Pattern text = Pattern.compile("\\[[^\\[]*\\]");

        Matcher matcher = text.matcher(sentencia);
        while (matcher.find()) {
            agrupaciones.add(new Label(matcher.group()));
        }

    }

    private void reservadas(String sentencia) {

        Pattern expresion = Pattern.compile("(TABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX)");

        //[A-Z|a-z][a-z|A-Z|_]*
        Matcher matcher = expresion.matcher(sentencia);

        while (matcher.find()) {
            reservadas.add(new Label(matcher.group()));
        }

    }

    private void caracteres(String sentencia) {
        Pattern expresion = Pattern.compile("[A-Z|a-z][a-z|A-Z|_]*[^\\WTABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX]");

        Matcher matcher = expresion.matcher(sentencia);
        while (matcher.find()) {
            caracteres.add(new Label(matcher.group()));
        }
    }

    private void errores(String sentencia) {
        Pattern expresion = Pattern.compile("");

        Matcher matcher = expresion.matcher(sentencia);
        while (matcher.find()) {
            errores.add(new Label(matcher.group()));
        }
    }

}
