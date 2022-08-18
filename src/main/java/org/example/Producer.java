package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    public AtomicInteger value;
    private Queue<Animal> queue;
    private AtomicBoolean wasInterrupted ;
    public AtomicInteger sum;
    public Producer(Queue<Animal> que) {
        this.queue = que;
        this.value=new AtomicInteger(1);
        this.wasInterrupted=new AtomicBoolean(false);
        this.sum=new AtomicInteger(0);
    }

    public void run() {
        try {

            Integer tmp=value.getAndIncrement();
             sum.addAndGet(tmp);

            if(queue.queueEnqueue(new Animal(tmp,'m')) == false){
                wasInterrupted.set(true);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWasInterrupted() {
        return wasInterrupted.get();
    }
}
