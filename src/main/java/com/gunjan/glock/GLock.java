package com.gunjan.glock;

public class GLock
{
    
    private boolean isLocked = false;
    
    public synchronized void lock() throws InterruptedException
    {
        while(isLocked)
        {
            wait();
        }
        isLocked = true;
    }
    
    public synchronized void unlock()
    {
        isLocked = false;
        notify();
    }
}