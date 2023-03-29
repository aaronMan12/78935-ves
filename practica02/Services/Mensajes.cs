<<<<<<< HEAD
using System;
using System.ServiceModel;

namespace WSDL.mensajes


{
    [ServiceContract]
    public interface Mensajes {
     [OperationContract]
    string Saludar (string nombre);
    [OperationContract]
    string Mostrar(int id);
}
    } 
=======
using System;
using System.ServiceModel;

namespace WSDL.mensajes


{
    [ServiceContract]
    public interface Mensajes {
     [OperationContract]
    string Saludar (string nombre);
    [OperationContract]
    string Mostrar(int id);
}
    } 
>>>>>>> bf579d56b19de821a3baefb20e804cc3224bef17
