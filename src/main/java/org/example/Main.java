package org.example;
import io.objectbox.Box;
import io.objectbox.BoxStore;

import java.util.Collection;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BoxStore store = MyObjectBox.builder().name("objectbox-queue-db").build();
        Box<Animal> box = store.boxFor(Animal.class);

        Queue<Animal> Q= new Queue<>(box);

//        for(int i=0;i<5;i++){
//            Animal a=new Animal(i+1,'m');
//            Q.queueEnqueue(a);
//        }
        Q.queueDisplay();
//        Q.queueDequeue();
//        Q.queueDequeue();
//        for(int i=10;i<15;i++){
//            Animal a=new Animal(i+1,'m');
//            Q.queueEnqueue(a);
//        }
//         Q.queueDisplay();
        store.close();
    }
}