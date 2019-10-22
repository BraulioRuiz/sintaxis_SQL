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
            
        }
        
    }
    
    private void revisarCaracterDB(String sentencia){
    
    }
    

}
