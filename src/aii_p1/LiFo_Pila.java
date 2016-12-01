package aii_p1;

public class LiFo_Pila {
      int a=1;
    public class Nodo{ // private
        int info;
        int linea;
        Nodo siguiente;
    
    public Nodo(int I, int l){
        info=I;
        linea=l;
        siguiente=null;
     }   
    } //clase Nodo
    
    public Nodo inicio,Recorre; //private
   int temporal;
    
    public LiFo_Pila(){
        inicio=null;
    }
    public boolean pila_vacia(){ // private
        return inicio==null;
    }
    public void Insertar(int dato, int l){
        Nodo Nuevo;
        if(pila_vacia()){
            inicio=new Nodo(dato, l);
            Recorre=inicio;
        }
        else
        {
            Nuevo = new Nodo(dato,l);
            Nuevo.siguiente=inicio;
            inicio=Nuevo;
            Nuevo=null;
        }
    }
    public int Eliminar(){
        if(!pila_vacia()){
            temporal =inicio.info;
            inicio=inicio.siguiente;        
        }
        return temporal;
    }
    
     public void VaciarPila()
    {
       while (pila_vacia()==false){
           Eliminar();         
       }
        
    }
   
}
