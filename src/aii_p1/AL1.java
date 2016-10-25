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

/**
 *
 * @author Joel
 */
public class AL1 {
    
    Tabla it = new Tabla();
    static String inf[] = new String[4];
       
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
                 
            StringTokenizer stc = new StringTokenizer(st.nextToken());
            
            while(stc.hasMoreTokens()){
                int te;
                String t = stc.nextToken();//forma un token con cada espacio
                
                String patron = ("(si[a-zA-Z]*\\d+)"//1
                              + "|(cont[a-zA-Z]*\\d+)"//2
                              + "|(num[a-zA-Z]*\\d+)"//3
                              + "|(cad[a-zA-Z]*\\d+)"//4
                              + "|(imp[a-zA-Z]*\\d+)"//5
                              + "|([a-zA-Z]+\\d+)"//6
                              + "|(\\d+.\\d+)"//7
                              + "|(\\d+)"//8
                              + "|(\\{)"//9
                              + "|(\\})"//10
                              + "|(\\[)"//11
                              + "|(\\])"//12
                              + "|(<)"//13
                              + "|(>)"
                              + "|(;)"//15
                              + "|(=)"
                              + "|(\\+)"
                              + "|(-)"
                              + "|(\\*)"//20
                              + "|(/)"
                              + "|(si)"
                              + "|(cont)"
                              + "|(num)"
                              + "|(cad)"
                              + "|(imp)"
                              + "|([^\\\\s=<>';])");
                        //('[\\s\\w.]*')|([^\\s=<>';])"); 
            
                Pattern p = Pattern.compile(patron);             
                Matcher mat = p.matcher(t);              
       
            while(mat.find()){
                String tokenTipo1 = mat.group(1);//siinden
                if(tokenTipo1 != null){
                    inf[0]="20";
                    inf[1]= "identificador";         
                    inf[2]=tokenTipo1;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }

                String tokenTipo2 = mat.group(2);//contiden
                    if(tokenTipo2 != null){
                        inf[0]="20"; 
                        inf[1]= "identificador";                                     
                        inf[2]=tokenTipo2;
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo3 = mat.group(3);//identificador
                    if(tokenTipo3 != null){
                        inf[0]="20"; 
                        inf[1]= "identificador";                                     
                        inf[2]=tokenTipo3;
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                
                String tokenTipo4 = mat.group(4);//identificador
                    if(tokenTipo4 != null){
                        inf[0]="20"; 
                        inf[1]= "identificador";                                     
                        inf[2]=mat.group(4);
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo5 = mat.group(5);//identificador
                    if(tokenTipo5 != null){
                        inf[0]="20"; 
                        inf[1]= "identificador";                                     
                        inf[2]=tokenTipo5;
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }    
                 
                String tokenTipo6 = mat.group(6);//identificador
                    if(tokenTipo6 != null){
                        inf[0]="20"; 
                        inf[1]= "identificador";                                     
                        inf[2]= tokenTipo6; 
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo7 = mat.group(7);//identificador
                    if(tokenTipo7 != null){
                        te = 0;                     
                        manejoErrores(t, linea, te);
                } 
                    
                String tokenTipo8 = mat.group(8);//identificador
                    if(tokenTipo8 != null){
                        inf[0]="21"; 
                        inf[1]= "numero";                                     
                        inf[2]=tokenTipo8;
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }     
                   
                String tokenTipo9 = mat.group(9);//identificador
                    if(tokenTipo9 != null){
                        inf[0]="20"; 
                        inf[1]= "llave_abierta";                                     
                        inf[2]=tokenTipo9; 
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                   
                String tokenTipo10 = mat.group(10);//identificador
                    if(tokenTipo10 != null){
                        inf[0]="21"; 
                        inf[1]= "llave_cerrada";                                     
                        inf[2]= tokenTipo10; 
                        inf[3]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }             
                 
                String tokenTipo11 = mat.group(11);//llave a
                if(tokenTipo11 != null){
                    inf[1]= "corchete_abierto";
                    inf[0]="22";                                   
                    inf[2]=tokenTipo11;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);               
                }
                
                String tokenTipo12 = mat.group(12);//llave c
                if(tokenTipo12 != null){
                    inf[1]= "corchete_cerrado";
                    inf[0]="23";
                    inf[2]=tokenTipo12;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo13 = mat.group(13);//<
                if(tokenTipo13 != null){
                    inf[1]= "menor_q";
                    inf[0]="40";
                    inf[2]=tokenTipo13;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);   
                }
                
                String tokenTipo14 = mat.group(14);//>
                if(tokenTipo14 != null){
                    inf[1]= "mayor_q";
                    inf[0]="41";
                    inf[2]=tokenTipo14;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                    
                }
               
                String tokenTipo15 = mat.group(15);//;
                if(tokenTipo15 != null){
                    inf[1]= "delimitador";
                    inf[0]="52";
                    inf[2]=tokenTipo15;  
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }
                 
                String tokenTipo16 = mat.group(16);//=
                if(tokenTipo16 != null){
                    inf[1]= "Asignacion";
                    inf[0]="42";
                    inf[2]=tokenTipo16;  
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                  
                }
               
                String tokenTipo17 = mat.group(17);//+
                if(tokenTipo17 != null){
                    inf[1]= "operador_suma";
                    inf[0]="43";
                    inf[2]=tokenTipo16;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo18 = mat.group(18);//-
                if(tokenTipo18 != null){
                    inf[1]= "operador_resta";
                    inf[0]="44";
                    inf[2]=tokenTipo18;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }
                 
                String tokenTipo19 = mat.group(19);//*
                if(tokenTipo18 != null){
                    inf[1]= "operador_mult";
                    inf[0]="45";
                    inf[2]=tokenTipo19;
                    inf[3]=String.valueOf(linea);            
                    it.llenarT(inf);                   
                }
                
                String tokenTipo20 = mat.group(20);//  div
                if(tokenTipo20 != null){
                    inf[1]= "operador_div";
                    inf[0]="46";
                    inf[2]=tokenTipo20;  
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                  
                }
               
                String tokenTipo21 = mat.group(21);//si
                if(tokenTipo21 != null){
                    inf[1]= "palabra_r";
                    inf[0]="10";
                    inf[2]=tokenTipo21;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }
                 
                String tokenTipo22 = mat.group(22);//)
                if(tokenTipo22 != null){
                    inf[1]= "palabra_r";
                    inf[0]="11";                  
                    inf[2]=tokenTipo22;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo23 = mat.group(23);//;
                if(tokenTipo23 != null){
                    inf[1]= "palabra_r";
                    inf[0]="12";                  
                    inf[2]=tokenTipo23;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo24 = mat.group(24);//'cadena'
                if(tokenTipo24 != null){
                    inf[1]= "palabra_r";
                    inf[0]="13";                  
                    inf[2]=tokenTipo24;
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                 String tokenTipo25 = mat.group(25);//=
                if(tokenTipo25 != null){
                    inf[1]= "operador_asig";
                    inf[0]="14";                  
                    inf[2]=tokenTipo25;   
                    inf[3]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo26 = mat.group(26);//=
                if(tokenTipo26 != null){
                    te = 1;                     
                        manejoErrores(t, linea, te);
                }
            }
            
            }
            linea ++;
        }      
    }
    
    
    public void manejoErrores(String t, int l, int r){
        int ide;//id del error
        String cad = IP1.mme.getText();
        
        switch(r){
            case 0:
                ide = 100;
                IP1.mme.setText(cad+" Error "+ide+"\n Se econtro un numero no valido,  en la linea "+l+"\n");             
                
                break;
            case 1:
                ide = 101;
                IP1.mme.setText(cad+" Error "+ide+"\n Se econtro un caracter que no pertenece al lenguaje,  en la linea "+l+"\n"); 
                break;
        }
            ide = 100;
            
        
        
    }
}
