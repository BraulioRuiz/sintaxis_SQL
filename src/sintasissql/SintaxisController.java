/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintasissql;

import java.util.ArrayList;
import java.util.Collection;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ayax9
 */
public class SintaxisController {
    @FXML
    private TextField sentencia;
    @FXML
    private TableView<String> tbResultado;
    @FXML
    private TableColumn<String, String> clToken;
    @FXML
    private TableColumn<String, String> clLexico;
    
    Collection<String> list = new ArrayList<>();
    
    @FXML
    void verificar(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){           
            reservadas(sentencia.getText());
            caracteres(sentencia.getText());
            revisarCaracterDB(sentencia.getText());
            revisarAgrupacion(sentencia.getText());
        }
        
    }    
    
    private void revisarCaracterDB(String sentencia){
        //System.out.println(sentencia);       
        
        Pattern text = Pattern.compile("[a-z][a-z|_|-|0-9]*");
       
        
        Matcher matcher = text.matcher(sentencia);
        while(matcher.find()){
            System.out.println("CARACTERES DB: "+ matcher.group());
        }
        clLexico.setCellValueFactory(cellData -> 
            new ReadOnlyStringWrapper(cellData.getValue()));
        
        
    }
    private void revisarAgrupacion(String sentencia){
        //System.out.println(sentencia);       
        
        Pattern text = Pattern.compile("\\[[^\\[]*\\]");
        
        Matcher matcher = text.matcher(sentencia);
        while(matcher.find()){
            System.out.println("AGRUPACIONES: "+ matcher.group());
        }
        
    }
    
    private void reservadas(String sentencia){
        Pattern expresion = Pattern.compile("(TABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX)");  
       
        //[A-Z|a-z][a-z|A-Z|_]*
          
        Matcher matcher = expresion.matcher( sentencia );     
        while ( matcher.find() )         
            System.out.println( "RESERVADAS: \n"+matcher.group() ); 
    }   
    
    private void caracteres(String sentencia){
       Pattern expresion = Pattern.compile("[A-Z|a-z][a-z|A-Z|_]*[^\\WTABLE|ALTER|CONSTRAINT|ADD|PRIMARY KEY|"
                + "UNIQUE|FULLTEXT|SPATIAL|FOREING KEY|FIRST|AFTER|INDEX]");  

        Matcher matcher = expresion.matcher( sentencia );     
        while ( matcher.find() )         
            System.out.println( "CARACTERES: \n"+matcher.group() ); 
    }   
    
    

}
