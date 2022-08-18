package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable{

    private Queue<Animal> queue;
    private boolean wasInterrupted = false;
    public AtomicInteger sum;
    public Consumer(Queue<Animal> que) {
        this.queue = que;
        this.sum=new AtomicInteger(0);
    }



    public void run() {
        try {
             Animal val=queue.queueDequeue();
             if(val!=null)
             sum.getAndAdd(val.getAge());
            if( val== null){
                wasInterrupted = true;
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWasInterrupted() {
        return wasInterrupted;
    }
}
