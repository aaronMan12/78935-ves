package mx.uv.practica03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ch.qos.logback.core.read.ListAppender;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.ListaRequest;
import https.t4is_uv_mx.saludos.ListaResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class EndPoint{
    ArrayList<String> nombres = new ArrayList<>();
    @PayloadRoot(localPart = "SaludarRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        nombres.add(peticion.getNombre());
        respuesta.setRespuesta("Hola " + peticion.getNombre());
        return respuesta;
    }

    @PayloadRoot(localPart = "ListaRequest", namespace="https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ListaResponse Lista(@RequestPayload ListaRequest peticion){
        ListaResponse respuesta = new ListaResponse();
        
        //respuesta.setRespuesta("Adios " + peticion.getNombre());
        if(nombres ==null||nombres.size()==0){
           // String retornado;
            respuesta.setSaludoretornado("Lista vacia");
        }else{
            respuesta.setSaludoretornado("HOLA:"+nombres.get(peticion.getValor()));
        }
        return respuesta;
    }

}