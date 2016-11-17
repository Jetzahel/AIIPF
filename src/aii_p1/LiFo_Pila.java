package aii_p1;


public class LiFo_Pila {
      int a=1;
    public class Nodo{ // private
        String info;
        Nodo siguiente;
    
    public Nodo(String I){
        info=I;
        siguiente=null;
    }
    
    } //clase Nodo
    
    public Nodo inicio,Recorre; //private
    String temporal;
    
    public LiFo_Pila(){
        inicio=null;
    }
    public boolean pila_vacia(){ // private
        return inicio==null;
    }
    public void Insertar(String dato){
        Nodo Nuevo;
        if(pila_vacia()){
            inicio=new Nodo(dato);
            Recorre=inicio;
        }
        else
        {
            Nuevo = new Nodo(dato);
            Nuevo.siguiente=inicio;
            inicio=Nuevo;
            Nuevo=null;
        }
    }
    public String Eliminar(){
        

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
