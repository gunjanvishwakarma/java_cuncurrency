package com.gunjan.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCode
{
    
    Lock reentrantLock = new ReentrantLock();
    public synchronized void outer() throws InterruptedException
    {
        try
        {
            reentrantLock.lock();
            System.out.println("Outer Entry");
            inner();
            System.out.println("Outer Exit");
        }
        finally
        {
            reentrantLock.unlock();
        }
        
        
    }
    
    public synchronized void inner() throws InterruptedException
    {
        try
        {
            reentrantLock.lock();
            System.out.println("Inner Entry");
            System.out.println("Inner Exit");
        }
        finally
        {
            reentrantLock.unlock();
        }
    }
}
