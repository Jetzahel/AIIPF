/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class AL1 {
    
    Tabla it = new Tabla();
    static String inf[] = new String[3];
       
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
        String na0 = (JOptionPane.showInputDialog("Escribe el nombre del archivo")+".txt");
                    
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
    
    public void generarTokens(String data){
           
        StringTokenizer st = new StringTokenizer(data,"\n");
        int linea=1;
        
        
        while(st.hasMoreTokens()){
            
            String patron = ("([{|}]+)|(si)|(cont)|(num)|(cad)|(leer)|(imp)|([a-zA-Z]+[0-9]+)"
                           + "|([0-9]+)|([<|>]+)|([(|)]+)|(;)|('[\\s\\w.]*')|(=)|([^\\s=<>';])"); 
            Pattern p = Pattern.compile(patron);          
            Matcher mat = p.matcher(st.nextToken());
            while(mat.find()){

                
                String tokenTipo1 = mat.group(1);
                if(tokenTipo1 != null){
                    inf[1]= "llave";
                    inf[0]="50";                  
                    inf[2]=tokenTipo1;
                    
                    it.llenarT(inf);                 
                }
                
                String tokenTipo2 = mat.group(2);
                if(tokenTipo2 != null){
                    inf[1]= "palabra r";
                    inf[0]="10";
                    inf[2]=tokenTipo2;  
                    
                    it.llenarT(inf);                   
                }
                
                String tokenTipo3 = mat.group(3);
                if(tokenTipo3 != null){
                    inf[1]= "palabra r";
                    inf[0]="11";                                   
                    inf[2]=tokenTipo3;
                    
                    it.llenarT(inf);               
                }
                
                String tokenTipo4 = mat.group(4);
                if(tokenTipo4 != null){
                    inf[1]= "tipo dato";
                    inf[0]="12";
                    inf[2]=tokenTipo4;
                    
                    it.llenarT(inf);
                }
                
                String tokenTipo5 = mat.group(5);
                if(tokenTipo5 != null){
                    inf[1]= "tipo dato";
                    inf[0]="13";
                    inf[2]=tokenTipo5;
                    
                    it.llenarT(inf);   
                }
                
                String tokenTipo6 = mat.group(6);
                if(tokenTipo6 != null){
                    inf[1]= "palabra r";
                    inf[0]="14";
                    inf[2]=tokenTipo6;
                    
                    it.llenarT(inf);
                    
                }
                
                String tokenTipo7 = mat.group(7);
                if(tokenTipo7 != null){
                    inf[1]= "palabra r";
                    inf[0]="15";
                    inf[2]=tokenTipo7;  
                    
                    it.llenarT(inf);                   
                }
                
                String tokenTipo8 = mat.group(8);
                if(tokenTipo8 != null){
                    inf[1]= "identificador";
                    inf[0]="20";
                    inf[2]=tokenTipo8;  
                    
                    it.llenarT(inf);                  
                }
                
                String tokenTipo9 = mat.group(9);
                if(tokenTipo9 != null){
                    inf[1]= "numero";
                    inf[0]="21";
                    inf[2]=tokenTipo9;
                    
                    it.llenarT(inf);
                }
                
                String tokenTipo10 = mat.group(10);
                if(tokenTipo10 != null){
                    inf[1]= "Ope_Comparacion";
                    inf[0]="30";
                    inf[2]=tokenTipo10;
                    
                    it.llenarT(inf);                   
                }
                
                String tokenTipo11 = mat.group(11);
                if(tokenTipo11 != null){
                    inf[1]= "parentecis";
                    inf[0]="52";
                    inf[2]=tokenTipo11;
                    
                    it.llenarT(inf);                   
                }
                
                String tokenTipo12 = mat.group(12);
                if(tokenTipo12 != null){
                    inf[1]= "delimitador";
                    inf[0]="54";
                    inf[2]=tokenTipo12;  
                    
                    it.llenarT(inf);                  
                }
                
                String tokenTipo13 = mat.group(13);
                if(tokenTipo13 != null){
                    inf[1]= "cadena";
                    inf[0]="22";
                    inf[2]=tokenTipo13;
                    
                    it.llenarT(inf);                   
                }
                
                String tokenTipo14 = mat.group(14);
                if(tokenTipo14 != null){
                    inf[1]= "asignacion";
                    inf[0]="31";                  
                    inf[2]=tokenTipo14;
                    
                    it.llenarT(inf);
                }
                
                String tokenTipo15 = mat.group(15);
                if(tokenTipo15 != null){
                    manejoErrores(tokenTipo15, linea);
                }               
            }
            linea ++;
        }      
    }
    
    
    public void manejoErrores(String e, int l){
        int ide;
        switch(e){
            case "@":
                ide = 100;
                System.out.println("Error "+ide);
                break;
            case "\\":
                ide = 101;
                
        }
        
    }
    public void llenarArray(){
         
     }
}
