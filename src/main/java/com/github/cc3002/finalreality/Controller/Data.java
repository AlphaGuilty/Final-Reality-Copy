package com.github.cc3002.finalreality.Controller;

/**
 *  * A class that permit wait for turn is no empty.
 * @author Tomas Secul.
 */


public class Data {
    private boolean bool = true;

    public synchronized void send() {
        bool = false;
        notifyAll();
    }

    public synchronized void receive() {
        while (bool) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
            }
        }
        bool = true;

        notifyAll();
    }

}