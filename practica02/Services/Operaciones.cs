<<<<<<< HEAD
using System;
using WSDL.mensajes;
using System.Collections;
namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
      List<string> a = new List<string>();
       
        public string Saludar(string nombre)
      {
        
        String msj = "Hola" + nombre;
        a.Add(nombre);
        return msj;
        //implementar para agregar los nombres a una coleccion
      } 

      
       //opcion en numero y regresa la posicion del arreglo 
       public String Mostrar(int id){
      if(id>a.Count()||id<0){
        return "Error de el indice buscado";
      }else{
        // String msjbueno="la persona que esta en esta posición es:"+personas.get(id);
        return a[id]; 
      }
        
      }
     
    }
}
=======
using System;
using WSDL.mensajes;
using System.Collections;
namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
      List<string> a = new List<string>();
       
        public string Saludar(string nombre)
      {
        
        String msj = "Hola" + nombre;
        a.Add(nombre);
        return msj;
        //implementar para agregar los nombres a una coleccion
      } 

      
       //opcion en numero y regresa la posicion del arreglo 
       public String Mostrar(int id){
      if(id>a.Count()||id<0){
        return "Error de el indice buscado";
      }else{
        // String msjbueno="la persona que esta en esta posición es:"+personas.get(id);
        return a[id]; 
      }
        
      }
     
    }
}
>>>>>>> bf579d56b19de821a3baefb20e804cc3224bef17
