/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */
public class AL1 {
    public void guardarCopia(){
        String  na0 = JOptionPane.showInputDialog("Escribe el nombre del archivo");
                     na0 +=".txt";
                    File fn = new File("microp/"+na0);
                     int cont = 0;
                    if(!fn.exists()){
                        try {
                            fn.createNewFile();
                        } catch (Exception e) {
                        }
                    }else{
                       
                        String  na1 = JOptionPane.showInputDialog(fn.getName()+" Ya existe escribe un nombre diferente");
                         na1 +=".txt";                       
                        
                        while(fn.getName().equals(na1)){
                         na1 = JOptionPane.showInputDialog(fn.getName()+" Ya existe escribe un nombre diferente");
                         na1 +=".txt";
                        }
                        File fnp = new File("microp/"+na1);
                        try {
                            fnp.createNewFile();
                        } catch (Exception e) {
                        }
                        
                        
                    }
    }
    
}
