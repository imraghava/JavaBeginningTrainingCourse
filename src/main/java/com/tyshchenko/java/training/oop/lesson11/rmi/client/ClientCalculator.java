package com.tyshchenko.java.training.oop.lesson11.rmi.client;

import com.tyshchenko.java.training.oop.lesson11.rmi.common.Calculator;
import com.tyshchenko.java.training.oop.lesson11.rmi.common.RMIConstants;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Alexander Tyshchenko.
 */
public class ClientCalculator {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1199);
        Calculator calculator = (Calculator) registry.lookup(RMIConstants.RMI_SERVICE);
        System.out.println(calculator.add(1, 2));
    }

}
