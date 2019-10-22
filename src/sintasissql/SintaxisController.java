/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintasissql;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/**
 *
 * @author ayax9
 */
public class SintaxisController {
    @FXML
    private TextField sentencia;

    @FXML
    private TableView<?> tbResultado;
    
    
    @FXML
    void verificar(KeyEvent event) {
        if(event.getCode()== KeyCode.ENTER){            
            revisarCaracterDB(sentencia.getText());
            reservadas(sentencia.getText());
            caracteres(sentencia.getText());
        }
        
    }
    
    private void revisarCaracterDB(String sentencia){
    
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
       Pattern expresion = Pattern.compile("[A-Z|a-z][a-z|A-Z|_]*");  

        Matcher matcher = expresion.matcher( sentencia );     
        while ( matcher.find() )         
            System.out.println( "CARACTERES: \n"+matcher.group() ); 
    }   
    
    

}
