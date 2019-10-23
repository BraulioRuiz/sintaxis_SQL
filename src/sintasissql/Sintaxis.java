/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintasissql;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author JulioCaballero
 */
public class Sintaxis {
    
    private String reservadas;

    private StringProperty prueba;

    public StringProperty getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = new SimpleStringProperty(prueba);
    }
    
    
    
    public String getReservadas() {
        return reservadas;
    }

    public void setReservadas(String reservadas) {
        this.reservadas = reservadas;
    }  

} 
