/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;
/**
 *
 * @author Joel
 */
public class Tabla {

    public void llenarT(String d[]){
        IP1.modelo.addRow(d);
    }
    
    public void limpiaTabla(){
        try{             
            while(IP1.modelo.getRowCount()!=0){
                IP1.modelo.removeRow(0);
            }           
        }catch(Exception e){
            
        }
    }
    
    public void modificarT(){
        
    }
    
    public void buscarT(String db){//datobuscado
        
        
    }
    

}
