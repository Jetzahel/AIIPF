/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel
 */
public class AL1 {
    
   
    public void escfi(String nf, String data){
        try {
            FileWriter fw=  new FileWriter(nf,true);
            BufferedWriter bw=  new BufferedWriter(fw);      
            PrintWriter  pw= new  PrintWriter (bw);
                                     
            pw.println(data); 
            pw.close();
            
        } catch (Exception e) {
        }
        
    }
    
    public void guardarCopia(String data){
        String  na0 = (JOptionPane.showInputDialog("Escribe el nombre del archivo")+".txt");
                    
                    File fn = new File("microp/"+na0);                    
                     
                    if(!fn.exists()){
                        try {
                            fn.createNewFile();
                            escfi(fn.getPath(),data);
                        } catch (Exception e) {
                        }
                    }else{
                       
                        String  na1 = JOptionPane.showInputDialog(fn.getName()+" Ya existe escribe un nombre diferente")+".txt";
                                              
                        
                        while(fn.getName().equals(na1)){
                         na1 = JOptionPane.showInputDialog(fn.getName()+" Ya existe escribe un nombre diferente")+".txt";
                       
                        }
                        File fnp = new File("microp/"+na1);
                        try {
                            fnp.createNewFile();
                            escfi(fnp.getPath(),data);
                        } catch (Exception e) {
                        }
                        
                        
                    }
    }
    
    public void generarT(){
        //StringTokenizer  st = 
        
        
    }
    
}
