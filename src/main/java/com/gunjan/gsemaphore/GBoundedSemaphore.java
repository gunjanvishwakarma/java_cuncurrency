package com.gunjan.gsemaphore;

public class GBoundedSemaphore
{
    private int signals = 0;
    private int bound = 0;
    
    public GBoundedSemaphore(int upperBound)
    {
        this.bound = upperBound;
    }
    
    public synchronized void take() throws InterruptedException
    {
        while(this.signals == bound)
        {
            wait();
        }
        this.signals++;
        this.notify();
    }
    
    public synchronized void release() throws InterruptedException
    {
        while(this.signals == 0)
        {
            wait();
        }
        this.signals--;
        this.notify();
    }
}