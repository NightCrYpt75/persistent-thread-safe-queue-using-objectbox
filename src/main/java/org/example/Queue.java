package org.example;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

public class Queue <T extends Animal>{
    private long front;
    private long rear;
    private Box<T> box;
    private int count;



    private int size;
    public Queue(Box<T> box) {
        this.front = this.rear = 1;
        this.box=box;
        this.count = 0;
        this.size=-1;
        List<T> tmp=box.getAll();
        if(tmp.size()>0){
            this.front=tmp.get(0).getId();
            this.rear=tmp.get(tmp.size()-1).getId();
            this.count=tmp.size();
        }
    }
    public Queue(Box<T> box,int size){
        this.size=size;
        this.front = this.rear = 1;
        this.box=box;
        this.count = 0;

    }

    Queue() {
        this.front = this.rear = 1;
        this.size=this.count = 0;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getFront() {
        return front;
    }

    public void setFront(long front) {
        this.front = front;
    }

    public long getRear() {
        return rear;
    }

    public void setRear(long rear) {
        this.rear = rear;
    }



    synchronized public boolean queueEnqueue(T value) throws InterruptedException {
        if(count==size){
            System.out.println("cannot insert more values,queue is full!!");
            return false;

        }
        value.setId(rear);
        box.put(value);
        rear++;
        count++;
        return true;
    }

    synchronized public T queueDequeue() throws InterruptedException {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return null;
        }
        T data = box.get(front);
        box.remove(front);
        front++;
        count--;
        return data;
    }

    public void queueDisplay() throws InterruptedException {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }else {
            System.out.println("Queue Elements");
            for (T animal : box.getAll()) {
                animal.showData();
            }
            System.out.println("------*******--------");
        }
    }

    public T queueFront() throws InterruptedException {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return null;
        }
        return box.get(front);
    }
}
