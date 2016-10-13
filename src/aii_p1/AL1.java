/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;
import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
    
    public void generarT(String data){
        
        
        
        StringTokenizer st = new StringTokenizer(data,"\n");
        int cont=1;
        
        while(st.hasMoreTokens()){
            
            String patron = ("([{|}]+)|(si)|(cont)|(num)|(cad)|(leer)|(imp)|([a-zA-Z]+[0-9]+)"
                           + "|([0-9]+)|([<|>]+)|([(|)]+)|(;)|('[\\s\\w.]*')|(=)"); 
            Pattern p = Pattern.compile(patron);
            Matcher mat = p.matcher(st.nextToken());
            
            while(mat.find()){
                
                
                String tokenTipo1 = mat.group(1);
                if(tokenTipo1 != null){
                    System.out.println("Delimitaor "+tokenTipo1);
                }
                
                String tokenTipo2 = mat.group(2);
                if(tokenTipo2 != null){
                    System.out.println("palabra reservada  "+tokenTipo2);
                }
                
                String tokenTipo3 = mat.group(3);
                if(tokenTipo3 != null){
                    System.out.println("palabra reservada  "+tokenTipo3);
                }
                
                String tokenTipo4 = mat.group(4);
                if(tokenTipo4 != null){
                    System.out.println("Tipo de Dato  "+tokenTipo4);
                }
                
                String tokenTipo5 = mat.group(5);
                if(tokenTipo5 != null){
                    System.out.println("Tipo de Dato  "+tokenTipo5);
                }
                
                String tokenTipo6 = mat.group(6);
                if(tokenTipo6 != null){
                    System.out.println("Pendiente  "+tokenTipo6);
                }
                
                String tokenTipo7 = mat.group(7);
                if(tokenTipo7 != null){
                    System.out.println("Pendiente  "+tokenTipo7);
                }
                
                
                String tokenTipo8 = mat.group(8);
                if(tokenTipo8 != null){
                    System.out.println("Variable  "+tokenTipo8);
                }
                
                String tokenTipo9 = mat.group(9);
                if(tokenTipo9 != null){
                    System.out.println("Número  "+tokenTipo9);
                }
                
                String tokenTipo10 = mat.group(10);
                if(tokenTipo10 != null){
                    System.out.println("comparacion "+tokenTipo10);
                }
                
                String tokenTipo11 = mat.group(11);
                if(tokenTipo11 != null){
                    System.out.println("parentecis  "+tokenTipo11);
                }
                
                String tokenTipo12 = mat.group(12);
                if(tokenTipo12 != null){
                    System.out.println("simbolo  "+tokenTipo12);
                }
                
                String tokenTipo13 = mat.group(13);
                if(tokenTipo13 != null){
                    System.out.println("cadena  "+tokenTipo13);
                }
                
                String tokenTipo14 = mat.group(14);
                if(tokenTipo14 != null){
                    System.out.println("asignacion  "+tokenTipo14);
                }
            }if(!mat.find()){
                System.out.println("Desconocido:  ");
            }
            
            
       
            cont ++;
        }
       
        
    }
    
}
