/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.mtp.poe.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author epsi
 */
@WebService(serviceName = "Calculatrice")
public class Calculatrice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Addition
     */
    
    @WebMethod(operationName = "addition")
    public double addition(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        //TODO write your implementation code here:
        return a + b ;
    }

    /**
     * Soustraction
     */
    
    @WebMethod(operationName = "soustraction")
    public double soustraction(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        //TODO write your implementation code here:
        return a - b ;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Multiplication")
    public double Multiplication(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        //TODO write your implementation code here:
        return a * b ;
    }

    /**
     * Division
     */
    
    @WebMethod(operationName = "division")
    public double division(@WebParam(name = "a") double a, @WebParam(name = "b") double b) throws Exception {
        if ( b== 0)
        {
            throw new Exception();
        }
        return a/b;
    }


}
