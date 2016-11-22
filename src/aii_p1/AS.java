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
public class AS {
    LiFo_Pila lf = new LiFo_Pila();

    
    public void llenarP(){
        lf.Insertar(1,1);  
        
        for (int i=IP1.modelo.getRowCount()-1; i >= 0; i--) {
            int dato = Integer.valueOf((String) IP1.modelo.getValueAt(i,0));
            int li = Integer.valueOf((String) IP1.modelo.getValueAt(i,2));
            lf.Insertar(dato,li);           
        }
        leerP();
        
    }
    int dat,line, error;
    
    public void num(int Estado){
        switch (Estado){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 12){//num
                          
                           Estado = 1;   
                           num(Estado);
                       }
                   break;
                   case 1:
                        line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                     
                       if(dat == 30){//identificador
                           Estado =2; 
                           num(Estado);
                       }else{
                           error = 0;
                           Estado =6; 
                           num(Estado);
                       }
                   break;
                   case 2:
                        line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                     
                       if(dat == 42){//=
                           Estado =3;
                           num(Estado);
                       }else if(dat==50){//;
                           Estado=5;
                           num(Estado);
                       }else{                         
                           error = 1;
                           Estado =6;
                           num(Estado);
                        }
                   break;
                   case 3:
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                    
                       if(dat == 31){// numero
                           Estado =4;
                           num(Estado);
                       }else{
                           error = 2;
                           Estado =6;
                           num(Estado);
                       }
                   break;
                   case 4:
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       if(dat == 50){// ;
                           Estado=5;
                           num(Estado);
                           //i++;
                       }else{
                           error = 3;
                           Estado=6;
                           num(Estado);
                       }
                   break;
                   case 5:
                       lf.Eliminar(); 
                       System.out.println("Exito");
                       Estado = 0;
                       
                   break;
                   case 6:  
                       Estado = 0;
                       manejoErrores(line, error);

                   break;
                }//fin switch    
    }//fin num
    
    int Estado,Estadosi;
    
    public void leerP(){
 
        
        
        int row = IP1.modelo.getRowCount();
        int liz = Integer.valueOf((String) IP1.modelo.getValueAt(row-1,2));

        for (int i=liz; i>0 ;i--) {
            Estado=0;
            
            num(Estado);
            cad(Estado);         
                //__________________________________si___________________________-
                switch (Estadosi){
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 10){//si
                           
                           Estadosi = 1;                       
                       }
                   break;
                   case 1:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;  
                       
                       if(dat == 22){//   (
                           Estadosi =2;                       
                       }else{
                           error = 5;
                           Estadosi =11;                             
                       }
                   break;
                   case 2:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 30){//identificador
                           Estadosi =3;                       
                       }else{                         
                           error = 6;
                           Estadosi =11;
                        }
                   break;
                   case 3:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 40||dat == 41){// operador de concatenacion
                           Estadosi =4;
                       }else{
                           error = 7;
                           Estadosi =11;                     
                       }
                   break;
                   case 4:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                     
                       if(dat == 30||dat == 31||dat == 32){// numero identificador o cadena
                           Estadosi=5;
                       
                       }else{
                           error = 8 ;
                           Estadosi=11;                          
                       }
                   break;
                   case 5:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                     
                       System.out.println(dat);
                       if(dat == 23){// )
                           Estadosi = 6;
                         
                       }else{
                           error = 9 ;
                           Estadosi = 11; 
                       }
                                             
                   break;
                   case 6:
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 20){// ;
                           Estadosi=7;
                           
                       }else{
                           error = 10 ;
                           Estadosi=11; 
                       }
                      
                   break;
                   case 7: 
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 20){// ;
                           Estadosi=7;
                           i++;
                       }else{
                           error = 11 ;
                           Estadosi=11; 
                       }
                   break;
                   case 8: 
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 21){// ;
                           Estadosi=9;
                           i++;
                       }else{
                           error = 12 ;
                           Estadosi=11; 
                       }
                   break;
                   case 9: 
                       line= lf.inicio.linea;
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       
                       if(dat == 50){// ;
                           Estadosi=10;
                           i++;
                       }else{
                           error = 12 ;
                           Estadosi=11; 
                       }
                   break;
                   case 10: 
                       Estadosi = 0;
                       System.out.println("Exito");
                       i--;
                   break;                     
                    case 11: 
                       lf.Eliminar();
                       Estadosi = 0;
                       manejoErrores(line, error);
                       i--;
                   break;
                }//fin switch
                
             
        }//fin for que recorre la pila 
        
    }//fin leerP();
    
    public void cad(int Estado){
        switch (Estado){
            
                   case 0:                     
                       dat =lf.inicio.info;
                       if(dat == 13){//num
                           line= lf.inicio.linea;
                           //Estado = 1;
                           cad(Estado=1);
                       }
                   break;
                   case 1:                      
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                     
                       if(dat == 30){//identificador
                          //Estado =2;
                           cad(Estado=2);
                       }else{
                           error = 0;
                           //Estado =6;
                           cad(Estado=6);
                       }
                   break;
                   case 2:
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                     
                       if(dat == 42){//=
                           //Estado =3;
                           cad(Estado=3);
                       }else if(dat==50){//;
                          // Estado=5; 
                           cad(Estado=5);
                       }else{                         
                           error = 1;
                           cad(Estado=6);
                           //Estado =6;
                        }
                   break;
                   case 3:
                       lf.Eliminar();                      
                       dat = lf.inicio.info;                    
                       if(dat == 32){// cadena
                           //Estado =4;
                           cad(Estado=4);
                       }else{
                           error = 4;
                          // Estado =6;  
                           cad(Estado=6);
                       }
                   break;
                   case 4:
                       lf.Eliminar();                      
                       dat = lf.inicio.info;
                       if(dat == 50){// ;
                           //Estado=5;
                           cad(Estado=5);
                       }else{
                           error = 3;
                           //Estado=6;
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
                IP1.mme.setText(cad+" Error5 "+ide+"\n Se esperaba un),  en la linea "+l+"\n"); 
                break;
            case 10:
                ide = 204;
                IP1.mme.setText(cad+" Error6 "+ide+"\n Se esperaba una cadena,  en la linea "+l+"\n"); 
                break;
            case 11:
                ide = 204;
                IP1.mme.setText(cad+" Error7 "+ide+"\n Se esperaba una cadena,  en la linea "+l+"\n"); 
                break;
            case 12:
                ide = 204;
                IP1.mme.setText(cad+" Error8 "+ide+"\n Se esperaba una cadena,  en la linea "+l+"\n"); 
                break;
            
        }    
    }//Fin manejoErr
    
}//fin clase AS
