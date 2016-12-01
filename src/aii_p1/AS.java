/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;

import java.awt.Color;

/**
 *
 * @author Joel
 */
public class AS {
    LiFo_Pila lf = new LiFo_Pila();
     int dat,line, error;
     int Estado,Estadosi,Estadocont,Estadoo;
    
    public void llenarP(){
        lf.Insertar(1,1);       
        for (int i=IP1.modelo.getRowCount()-1; i >= 0; i--) {
            int dato = Integer.valueOf((String) IP1.modelo.getValueAt(i,0));
            int li = Integer.valueOf((String) IP1.modelo.getValueAt(i,2));
            lf.Insertar(dato,li);           
        }
        leerP();       
    }// fin llenar Pila
   
    
    public void leerP(){ 
        
        try {
            int row = IP1.modelo.getRowCount();
        int liz = Integer.valueOf((String) IP1.modelo.getValueAt(row-1,2));
        System.out.println(liz);
        for (int i=liz; i>0 ;i--) {
            Estado=0;
            Estadosi=0;
            Estadocont=0;
            Estadoo=0;
            System.out.println(lf.inicio.info);
            int dato=lf.inicio.info;
            switch(dato){
                case 12://num
                    num(Estado);
                break;
                case 30://iden
                    op(Estadoo);
                break;
                case 13://cad
                    cad(Estado);
                break;
                case 10:
                    si(Estadosi);
                break;
                case 11:
                    cont(Estadocont);
                break;                    
            }           
                //__________________________________si___________________________-            
        }//fin for que recorre la pila 
            
        } catch (Exception e) {
        }
        
        
    }//fin leerP();
    
    public void op(int Estadoo){
        switch (Estadoo){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 30){// Cont
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=1);                          
                       }
                   break;
                   case 1:                     
                       dat =lf.inicio.info;
                       if(dat == 42){// =
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=2);
                       }else{
                           error=13;
                           op(Estadoo=7);                         
                       }
                   break;
                   case 2:                     
                       dat =lf.inicio.info;
                       if(dat == 30||dat==31){// (
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=3);
                       }else{
                           error=12;
                           op(Estadoo=7);                         
                       }
                   break;
                   case 3:                     
                       dat =lf.inicio.info;
                       if(dat == 43||dat==44||dat==45||dat==46){// (
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=4);
                       }else if(dat == 50){
                           lf.Eliminar();
                           op(Estadoo=6);
                       }else{
                           error=17;
                           op(Estadoo=7);                         
                       }
                   break;
                   case 4:                     
                       dat =lf.inicio.info;
                       if(dat == 30||dat==31){// (
                           if(lf.inicio.linea==line){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=5);
                           }
                       }else{
                           error=12;
                           op(Estadoo=7);                         
                       }
                   break;
                   case 5:                     
                       dat =lf.inicio.info;
                       if(dat == 50){// (
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           op(Estadoo=6);
                       }else{
                           error=3;
                           op(Estadoo=7);                         
                       }
                   break;
                   case 6:                     
                       Estadoo=0;
                   break;    
                   case 7:                     
                       Estadoo = 0;
                       manejoErrores(line, error);
                   break; 
        }
    }
    
    public void cont(int Estadocont){
        switch (Estadocont){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 11){// Cont
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=1);                          
                       }
                   break;
                   case 1:                     
                       dat =lf.inicio.info;
                       if(dat == 22){// (
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=2);
                       }else{
                           error=5;
                           cont(Estadocont=15);                         
                       }
                   break;
                   case 2:                     
                       dat =lf.inicio.info;
                       if(dat == 12){// num
                          line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=3);
                       }else if(dat==30){// identificador
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=4);
                       }else{
                           error=12;
                           cont(Estadocont=15);
                       }
                   break;
                   case 3:
                       dat =lf.inicio.info;
                       if(dat==30){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=4);                        
                       }else{
                           error=0;
                           cont(Estadocont=15);
                       }
                       
                   break;
                   case 4:
                       dat =lf.inicio.info;
                       if(dat==42){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=5); 
                       }else{
                           error= 13;
                           cont(Estadocont=15);
                       }
                   break;
                   case 5:
                       dat =lf.inicio.info;
                       if(dat==31){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=6);
                       }else{
                           error=2;
                           cont(Estadocont=15);
                       }
                   break;
                   case 6:
                       dat =lf.inicio.info;
                       if(dat==50){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=7);
                       }else{
                           error=3;
                           cont(Estadocont=15);
                       }
                   break;
                   case 7:
                       dat =lf.inicio.info;
                       if(dat==30){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                          cont(Estadocont=8);
                       }else{
                           error=0;
                           cont(Estadocont=15);
                       }
                   break;
                   case 8:
                       dat =lf.inicio.info;
                       System.out.println(dat);
                       if(dat == 40||dat == 41){// operador de concatenacion
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=9);
                       }else if(dat ==42){
                           lf.Eliminar();                      
                           dat = lf.inicio.info;
                           if(dat ==42){
                               line= lf.inicio.linea;
                                lf.Eliminar();
                               cont(Estadocont=9);
                           }else{
                               error = 7;
                           cont(Estadocont =15);
                           }
                       }else{
                           error = 7;
                           cont(Estadocont =15);                     
                       }                    
                   break;
                   case 9:
                       dat =lf.inicio.info;
                       if(dat==31 || dat==30){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=10);                           
                       }else{
                           error=12;
                           cont(Estadocont=15);
                       }
                       
                   break;
                   case 10:
                       dat =lf.inicio.info;
                       if(dat==50){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=11);
                       }else{
                           error=3;
                           cont(Estadocont=15);
                       }
                   break;
                   case 11:
                       dat =lf.inicio.info;
                       if(dat==30){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=12);
                       }else{
                           error=0;
                           cont(Estadocont=15);
                       }
                      
                   break;
                   case 12:
                       dat =lf.inicio.info;
                       if(dat==43){
                           lf.Eliminar();
                           dat =lf.inicio.info;
                           if(dat==43){
                               lf.Eliminar();
                               dat =lf.inicio.info;
                               cont(Estadocont=13);
                           }else{
                               error=14;
                           cont(Estadocont=15);
                           }            
                       }else if(dat==44){
                           lf.Eliminar();
                           dat =lf.inicio.info;
                           if(dat==44){
                               lf.Eliminar();
                               dat =lf.inicio.info;
                               cont(Estadocont=13);
                           }else{
                               error=15;
                           cont(Estadocont=15);
                           }  
                       }else{
                           error=16;
                           cont(Estadocont=15);
                       }
                   break;
                   case 13:
                       dat=lf.inicio.info;
                       if(dat==23){
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=14);
                       }else{
                           error=9;
                           cont(Estadocont=15);
                       }
                   break;
                   case 14:
                       dat=lf.inicio.info;
                       if(dat==20){// {
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=16);
                       }else{
                           error=10;
                           cont(Estadocont=15);
                       }
                       
                   break;
                   case 15:
                       Estado = 0;
                       manejoErrores(line, error);
                   break;
                   case 16:
                       dat=lf.inicio.info;
                       System.out.println(dat);
                       if(dat==12||dat==13||dat==10){
                           num(Estado=0);
                           cad(Estado=0);                          
                           si(Estadosi=0);
                           cont(Estadocont=16);
                       }else if(dat == 21){// }
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           cont(Estadocont=18);
                         }else{                         
                           error = 11 ;
                           si(Estadosi=10); 
                       }
                   break;
                   case 18:                      
                       Estadocont=0;
                   break;
        }
        
    }
    
    public void si(int Estadosi){
        switch (Estadosi){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 10){//si                         
                           si(Estadosi=1);                       
                       }
                   break;
                   case 1:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                        
                       if(dat == 22){//   (
                           si(Estadosi =2);                       
                       }else{
                           error = 5;
                           si(Estadosi =10);                             
                       }
                   break;
                   case 2:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 30){//identificador
                           si(Estadosi=3);
                              
                       }else{                         
                           error = 6;
                          si(Estadosi =10);
                        }
                   break;
                   case 3:                     
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       if(dat == 40||dat == 41){// operador de concatenacion
                           si(Estadosi=4);
                       }else if(dat ==42){
                           lf.Eliminar();                      
                           dat = lf.inicio.info;
                           if(dat ==42){
                               si(Estadosi=4);
                           }else{
                               error = 7;
                           si(Estadosi=10);
                           }
                       }else{
                           error = 7;
                           si(Estadosi=10);                     
                       }
                   break;
                   case 4:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                    
                       if(dat == 30||dat == 31||dat == 32){// numero identificador o cadena
                           si(Estadosi=5);                     
                       }else{
                           error = 8 ;
                           si(Estadosi=10);                          
                       }
                   break;
                   case 5:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       if(dat == 23){// )
                           si(Estadosi = 6);                       
                       }else{
                           error = 9 ;
                           si(Estadosi = 10); 
                       }                                            
                   break;
                   case 6:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 20){//  {
                           line= lf.inicio.linea;
                           lf.Eliminar();                      
                            dat = lf.inicio.info;
                           si(Estadosi=7);                         
                       }else{
                           error = 10 ;
                           si(Estadosi=10); 
                       }
                      
                   break;
                   case 7:                                   
                       if(dat==12||dat==13){
                           num(Estado=0);
                           cad(Estado=0);
                           si(Estadosi=7);
                       }else if(dat == 21){// }
                           si(Estadosi=9);
                         }else{                         
                           error = 11 ;
                           si(Estadosi=10); 
                       }
                   break;
                   case 9: 
                       lf.Eliminar();                      
                       Estadosi=0;
                   break;
                   case 10: 
                       Estadosi = 0;
                       manejoErrores(line, error);
                   break;                     
                }//fin switch
    }
    
    public void num(int Estado){
        switch (Estado){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 12){//num 
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           num(Estado=1);
                       }
                   break;
                   case 1:                                           
                       dat = lf.inicio.info;                     
                       if(dat == 30){//identificador
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           num(Estado=2);
                       }else{
                           error = 0; 
                           num(Estado=6);
                       }
                   break;
                   case 2:                                             
                       dat = lf.inicio.info;                     
                       if(dat == 42){//=
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           num(Estado=3);
                       }else if(dat==50){//;
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           num(Estado=5);
                       }else{                         
                           error = 1;
                           num(Estado=6);
                        }
                   break;
                   case 3:                      
                       dat = lf.inicio.info;                    
                       if(dat == 31 || dat == 32){// numero
                           line= lf.inicio.linea;
                           lf.Eliminar();
                           num(Estado=4);
                       }else{
                           error = 2;
                           num(Estado=6);
                       }
                   break;
                   case 4:                      
                       dat = lf.inicio.info;
                       if(dat == 50){// ;
                           lf.Eliminar();
                           num(Estado=5);
                       }else{
                           error = 3;
                           num(Estado=6);
                       }
                   break;
                   case 5:                      
                       Estado = 0;                      
                   break;
                   case 6:
                       Estado = 0;
                       manejoErrores(line, error);
                   break;
                }//fin switch    
    }//fin num
    
    public void cad(int Estado){
        switch (Estado){         
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 13){//cad                         
                           cad(Estado=1);
                       }
                   break;
                   case 1:    
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                                    
                       if(dat == 30){//identificador
                           cad(Estado=2);
                       }else{
                           error = 0;
                           cad(Estado=6);
                       }
                   break;
                   case 2:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                       
                       if(dat == 42){//=
                           cad(Estado=3);
                       }else if(dat==50){//;
                           cad(Estado=5);
                       }else{       
                           error = 1;
                           cad(Estado=6);
                        }
                   break;
                   case 3:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                       
                       if(dat == 32 || dat== 31){// cadena
                           cad(Estado=4);
                       }else{
                           error = 4;
                           cad(Estado=6);
                       }
                   break;
                   case 4:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;   
                       if(dat == 50){// ;
                           cad(Estado=5);
                       }else{
                           error = 3;
                           cad(Estado=6);
                       }
                   break;
                   case 5:
                       lf.Eliminar();                      
                       Estado = 0;                 
                   break;
                   case 6:
                       Estado = 0;
                       manejoErrores(line, error);
                   break;
                }//fin switchcad
    }
    
    public void manejoErrores(int l, int r){
        int ide;//id del error
        String cad = IP1.mme.getText();   
        IP1.mme.setForeground(Color.red);
        switch(r){
            case 0:
                ide = 200;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un identificador,  en la linea "+l+"\n"); 
                break;
            case 1:
                ide = 201;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un '=' o un ';',  en la linea "+l+"\n"); 
                break;
            case 2:
                ide = 202;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un numero,  en la linea "+l+"\n"); 
                break;
            case 3:
                ide = 203;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un ';',  en la linea "+l+"\n"); 
                break;
            case 4:
                ide = 204;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba una cadena,  en la linea "+l+"\n"); 
                break;
            case 5:
                ide = 205;
                IP1.mme.setText(cad+" Error1 "+ide+"\n Se esperaba un (,  en la linea "+l+"\n"); 
                break;
            case 6:
                ide = 206;
                IP1.mme.setText(cad+" Error2 "+ide+"\n Se esperaba un identificador,  en la linea "+l+"\n"); 
                break;
            case 7:
                ide = 207;
                IP1.mme.setText(cad+" Error3 "+ide+"\n Se esperaba un operador de comparacion,  en la linea "+l+"\n"); 
                break;
            case 8:
                ide = 208;
                IP1.mme.setText(cad+" Error4 "+ide+"\n Se esperaba un identificador ó un numero o una cadena,  en la linea "+l+"\n"); 
                break;
            case 9:
                ide = 209;
                IP1.mme.setText(cad+" Error5 "+ide+"\n Se esperaba un ),  en la linea "+l+"\n"); 
                break;
            case 10:
                ide = 204;
                IP1.mme.setText(cad+" Error6 "+ide+"\n Se esperaba un {,  en la linea "+l+"\n"); 
                break;
            case 11:
                ide = 211;
                IP1.mme.setText(cad+" Error7 "+ide+"\n Se esperaba un },  en la linea "+l+"\n"); 
                break;
            case 12:
                ide = 212;
                IP1.mme.setText(cad+" Error8 "+ide+"\n Se esperaba un num o un identificador ,  en la linea "+l+"\n"); 
                break;
            case 13:
                ide = 213;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un = ,  en la linea "+l+"\n"); 
                break;
            case 14:
                ide = 214;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un + ,  en la linea "+l+"\n"); 
                break;
            case 15:
                ide = 215;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un - ,  en la linea "+l+"\n"); 
                break;
            case 16:
                ide = 216;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un INC ó DEC ,  en la linea "+l+"\n"); 
                break;
            case 17:
                ide = 217;
                IP1.mme.setText(cad+" Error "+ide+"\n Se esperaba un operador aritmetico ó un ; ,  en la linea "+l+"\n"); 
                break;           
        }    
    }//Fin manejoErr
    
}//fin clase AS
