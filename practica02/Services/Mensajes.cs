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
>>>>>>> bd72be0d6b7c38ba05dad4ea142285701f90e000
