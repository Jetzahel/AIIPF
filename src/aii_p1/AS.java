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
        int is = IP1.modelo.getRowCount();
        
        for (int i=IP1.modelo.getRowCount()-1; i >= 0; i--) {
            int dato = Integer.valueOf((String) IP1.modelo.getValueAt(i,0));
            lf.Insertar(dato);
            
        }
        leerP();
        
    }
    int dat;
    public void leerP(){
        int Estado= 0;
        for (int i=IP1.modelo.getRowCount(); 0 < i ; i--) {
            if(!lf.pila_vacia()){
                dat =lf.inicio.info;
            }  
            if(dat == 12){
                switch (Estado){
                   case 0:
                       if(dat == 12){//num
                           Estado = 1;                       
                       }
                   break;
                   case 1:
                       if(dat == 20){//identificador
                           Estado =2;                       
                       }
                   break;
                   case 2:
                       if(dat == 42){//=
                           Estado =3;                       
                       }else if(dat==52){//;
                           Estado=5;
                           i++;
                       }
                   break;
                   case 3:
                       if(dat == 21){//numero
                           Estado =4;
                           i++;
                       }
                   break;
                   case 4:
                       if(dat ==52){//;
                           Estado=5;                                            
                       }
                   break;
                   case 5:
                       System.out.println("Exito");
                   break;
                }//fin switch
        }//fin if si lee un num
            lf.Eliminar();
        }//fin for que recorre la pila 
        
        
    }//fin leerP();
    
}//fin clase AS
