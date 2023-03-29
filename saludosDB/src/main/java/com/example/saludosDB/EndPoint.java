package com.example.saludosDB;

import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//import ch.qos.logback.core.read.ListAppender;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.ActualizarRequest;
import https.t4is_uv_mx.saludos.ActualizarResponse;
import https.t4is_uv_mx.saludos.EliminarRequest;
import https.t4is_uv_mx.saludos.EliminarResponse;
import https.t4is_uv_mx.saludos.LeerRequest;
import https.t4is_uv_mx.saludos.LeerResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class EndPoint{
    @Autowired
    private ISaludador iSaludador;
    ArrayList<String> nombres = new ArrayList<>();
    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        nombres.add(peticion.getNombre());
        respuesta.setRespuesta("Hola " + peticion.getNombre());
        //lineas para crear la tabla en la base de datos
        Saludador saludador =new Saludador();
        saludador.setnombre(peticion.getNombre());
        iSaludador.save(saludador);
        return respuesta;
    }

    @PayloadRoot(localPart = "LeerRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public LeerResponse Leer(@RequestPayload LeerRequest leido){
        LeerResponse respuesta=new LeerResponse();
        Saludador nuevo =new Saludador();
        nuevo.setId(leido.getId());
        Optional<Saludador> saludoRetornado=iSaludador.findById(leido.getId());
        Saludador nuevo2 =saludoRetornado.get();
        if(nuevo2.getId()==null){
            respuesta.setSaludoretornado("no se encontro nadie con ese ID");
        }else{
        respuesta.setSaludoretornado("El ID es de:"+nuevo2.getnombre());
        
        }
       // String r1=peticion.toString();
       return respuesta; 
    }

    @PayloadRoot(localPart = "EliminarRequest", namespace ="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse Eliminar(@RequestPayload EliminarRequest eliminado){
        EliminarResponse respuesta= new EliminarResponse();
        iSaludador.deleteById(eliminado.getId());
        respuesta.setSaludoretornado("eliminado con id:"+eliminado.getId());
        return respuesta;
    }

    @PayloadRoot(localPart = "ActualizarRequest", namespace ="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ActualizarResponse Actualizar(@RequestPayload ActualizarRequest actualizado){
        ActualizarResponse respuesta=new ActualizarResponse();
        Saludador nuevo=new Saludador();
        nuevo.setId(actualizado.getId());
        nuevo.setnombre(actualizado.getNuevoNombre());
        if(iSaludador.existsById(nuevo.getId())==true){
          iSaludador.save(nuevo);  
        }else{
            respuesta.setSaludoretornado("no existe en la base de datos ese usuario");
        }
        
        return respuesta;
    }


}


  //respuesta.setRespuesta("Adios " + peticion.getNombre());
       /* if(nombres ==null||nombres.size()==0){
            // String retornado;
             respuesta.setSaludoretornado("Lista vacia");
         }else{
             respuesta.setSaludoretornado("HOLA:"+nombres.get(peticion.getValor()));
         }*/