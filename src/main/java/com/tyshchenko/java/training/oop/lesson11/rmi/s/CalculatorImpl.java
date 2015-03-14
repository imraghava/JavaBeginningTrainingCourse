package com.tyshchenko.java.training.oop.lesson11.rmi.s;

import com.tyshchenko.java.training.oop.lesson11.rmi.common.Calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Alexander Tyshchenko.
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
    }

    @Override
    public long add(long a, long b) throws RemoteException {
        return a + b;
    }
}
