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
    
    int Estado;
    public void generarTokens(String data){
        
        int a1=0, a2=0;   
        StringTokenizer st = new StringTokenizer(data,"\n");
        int linea=0;
        
        while(st.hasMoreTokens()){
                 String t1 = st.nextToken();
                 if(t1.contains("//")){
                     linea++;
                    
                }else{
                     linea++;
                
            StringTokenizer stc = new StringTokenizer(t1);
            
            while(stc.hasMoreTokens()){
                int te;
                String t = stc.nextToken();//forma un token con cada espacio 
                
               
               String  cadenacom = "";      
                Estado=0;
              
        for(int indice=0;indice<t.length();indice++){
           char letra = t.charAt(indice);
          
           switch (Estado){
               case 0:
                   if(letra == 's'){
                       Estado = 1;                
                       cadenacom += letra;
                   }
               break;
               case 1:
                    if(letra == 'i'){
                        Estado = 2;                
                        cadenacom += letra;
                    }
               break;
               case 2:                 
                    if(Character.isLetter(letra)){
                       Estado = 2;
                    cadenacom += letra;
                        }
                    else if(Character.isDigit(letra)){
                        Estado = 3; 
                        cadenacom += letra;
                        indice--;
                    }else{
                        Estado = 4;
                    }
               break;
               case 3:                                   
                       row("30","identificador",cadenacom,linea);
               break;
               case 4:
                   Estado=0;
               break;
            }// fin Switch
        }//fin for
                        
                              
                String patron = ("(si[a-zA-Z]*\\d+)"//1
                              + "|(cont[a-zA-Z]*\\d+)"//2
                              + "|(num[a-zA-Z]*\\d+)"//3
                              + "|(cad[a-zA-Z]*\\d+)"//4
                              + "|(imp[a-zA-Z]*\\d+)"//5
                              + "|([a-zA-Z]+\\d+)"//6
                              + "|(\\d+[;.,]\\d+)"//7
                              + "|(\\d+)"//8
                              + "|(\\{)"//9
                              + "|(\\})"//10
                              + "|(\\()"//11
                              + "|(\\))"//12
                              + "|(<)"//13
                              + "|(>)"
                              + "|(;)"//15
                              + "|(=)"
                              + "|(\\+)"//17
                              + "|(-)"
                              + "|(\\*)"//
                              + "|(/)"//20
                              + "|(si)"//21
                              + "|(cont)"
                              + "|(num)"
                              + "|(cad)"
                              + "|(imp)"//25
                              + "|([^\\s=<>';\\(\\)])"//26
                              + "|('[\\s\\w.]*')"); //27
            
                Pattern p = Pattern.compile(patron);             
                Matcher mat = p.matcher(t);   
                      int cont=1;
            while(mat.find()){

                String tokenTipo2 = mat.group(2);//contiden
                    if(tokenTipo2 != null){
                        inf[0]="30"; 
                        //inf[1]= "identificador";                                     
                        inf[1]=tokenTipo2;
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo3 = mat.group(3);//identificador
                    if(tokenTipo3 != null){
 
                        inf[0]="30"; 
                        //inf[1]= "identificador";                                     
                        inf[1]=tokenTipo3;
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                
                String tokenTipo4 = mat.group(4);//identificador
                    if(tokenTipo4 != null){
                        inf[0]="30"; 
                        //inf[1]= "identificador";                                     
                        inf[1]=mat.group(4);
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo5 = mat.group(5);//identificador
                    if(tokenTipo5 != null){
                        inf[0]="30"; 
                        //inf[1]= "identificador";                                     
                        inf[1]=tokenTipo5;
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }    
                 
                String tokenTipo6 = mat.group(6);//identificador
                    if(tokenTipo6 != null){
                        inf[0]="30"; 
                        //inf[1]= "identificador";                                     
                        inf[1]= tokenTipo6; 
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                    
                String tokenTipo7 = mat.group(7);//identificador
                    if(tokenTipo7 != null){
                        te = 0;                     
                        manejoErrores(t, linea, te);
                } 
                    
                String tokenTipo8 = mat.group(8);//identificador
                    if(tokenTipo8 != null){
                        
                        if(IP1.modelo.getValueAt(a1, 1).equals("=") && null==IP1.modelo.getValueAt(a1-1,3)){
                           IP1.modelo.setValueAt(tokenTipo8, a1-1,3);
                        }
                        inf[0]="31"; 
                        //inf[1]= "numero";                                     
                        inf[1]=tokenTipo8;
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }     
                   
                String tokenTipo9 = mat.group(9);//identificador
                    if(tokenTipo9 != null){
                        inf[0]="20"; 
                        //inf[1]= "llave_abierta";                                     
                        inf[1]=tokenTipo9; 
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }
                   
                String tokenTipo10 = mat.group(10);//identificador
                    if(tokenTipo10 != null){
                        inf[0]="21"; 
                        //inf[1]= "llave_cerrada";                                     
                        inf[1]= tokenTipo10; 
                        inf[2]=String.valueOf(linea);
                        it.llenarT(inf);                      
                }             
                 
                String tokenTipo11 = mat.group(11);//  (
                if(tokenTipo11 != null){
                    //inf[1]= "corchete_abierto";
                    inf[0]="22";                                   
                    inf[1]=tokenTipo11;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);               
                }
                
                String tokenTipo12 = mat.group(12);// )
                if(tokenTipo12 != null){
                    //inf[1]= "corchete_cerrado";
                    inf[0]="23";
                    inf[1]=tokenTipo12;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo13 = mat.group(13);//<
                if(tokenTipo13 != null){
                    //inf[1]= "menor_q";
                    inf[0]="40";
                    inf[1]=tokenTipo13;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);   
                }
                
                String tokenTipo14 = mat.group(14);//>
                if(tokenTipo14 != null){
                    //inf[1]= "mayor_q";
                    inf[0]="41";
                    inf[1]=tokenTipo14;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                    
                }
               
                String tokenTipo15 = mat.group(15);//;
                if(tokenTipo15 != null){
                    //inf[1]= "delimitador";
                    inf[0]="50";
                    inf[1]=tokenTipo15;  
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }
                 
                String tokenTipo16 = mat.group(16);//=
                if(tokenTipo16 != null){
                    a1 = IP1.modelo.getRowCount();
                    //inf[1]= "Asignacion";
                    inf[0]="42";
                    inf[1]=tokenTipo16;  
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);                  
                }
               
                String tokenTipo17 = mat.group(17);//+
                if(tokenTipo17 != null){
                    //inf[1]= "operador_suma";
                    inf[0]="43";
                    inf[1]=tokenTipo16;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo18 = mat.group(18);//-
                if(tokenTipo18 != null){
                    //inf[1]= "operador_resta";
                    inf[0]="44";
                    inf[1]=tokenTipo18;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);                   
                }
                 
                String tokenTipo19 = mat.group(19);//*
                if(tokenTipo18 != null){
                    //inf[1]= "operador_mult";
                    inf[0]="45";
                    inf[1]=tokenTipo19;
                    inf[2]=String.valueOf(linea);            
                    it.llenarT(inf);                   
                }
                
                String tokenTipo20 = mat.group(20);//  div /
                if(tokenTipo20 != null){ 
                    inf[0]="46";
                    inf[1]=tokenTipo20;  
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                               
                }
               
                String tokenTipo21 = mat.group(21);//si
                if(tokenTipo21 != null){
                    //inf[1]= "palabra_r";
                    inf[0]="10";
                    inf[1]=tokenTipo21;
                    inf[2]=String.valueOf(linea);              
                    it.llenarT(inf);  
                     //linea--;
                }
                 
                String tokenTipo22 = mat.group(22);//
                if(tokenTipo22 != null){
                    //inf[1]= "palabra_r";
                    inf[0]="11";                  
                    inf[1]=tokenTipo22;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo23 = mat.group(23);//;
                if(tokenTipo23 != null){
                  
                    //inf[1]= "palabra_r";
                    inf[0]="12";                  
                    inf[1]=tokenTipo23;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo24 = mat.group(24);//'cadena'
                if(tokenTipo24 != null){
                    //inf[1]= "palabra_r";
                    inf[0]="13";                  
                    inf[1]=tokenTipo24;
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                 String tokenTipo25 = mat.group(25);//=
                if(tokenTipo25 != null){
                    //inf[1]= "operador_asig";
                    inf[0]="14";                  
                    inf[1]=tokenTipo25;   
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
                
                String tokenTipo26 = mat.group(26);//=
                if(tokenTipo26 != null){
                    te = 1;                     
                        manejoErrores(t, linea, te);
                }
                
                String tokenTipo27 = mat.group(27);//=
                if(tokenTipo27 != null){
                    
                    if(IP1.modelo.getValueAt(a1, 1).equals("=") && null==IP1.modelo.getValueAt(a1-1,3)){
                           IP1.modelo.setValueAt(tokenTipo27, a1-1,3);
                        }
                    //inf[1]= "cadena";
                    inf[0]="32";                  
                    inf[1]=tokenTipo27;   
                    inf[2]=String.valueOf(linea);
                    it.llenarT(inf);
                }
            }
             
            }
            
        }
                 
        } 
       
    }
    
  
    
    
    public void row(String p1,String p2,String p3, int p4){
                    inf[0]=p1;
                    //inf[1]=p2;                  
                    inf[1]=p3;   
                    inf[2]=String.valueOf(p4);
                    it.llenarT(inf);
                    
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
            case 2:
                ide = 102;
                IP1.mme.setText(cad+" Error "+ide+"\n Se econtro un caracter que no pertenece al lenguaje,  en la linea "+l+"\n"); 
                break;
            
        }    
    }
}