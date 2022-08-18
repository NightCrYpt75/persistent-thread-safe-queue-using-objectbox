import io.objectbox.Box;
import io.objectbox.BoxStore;
import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTests {
    // 2 producers can add and 2 consumer can remove from a queue concurrently
    @Test
    public void Test1()throws InterruptedException{
        BoxStore store = MyObjectBox.builder().name("objectbox-queue-db").build();
        Box<Animal> box = store.boxFor(Animal.class);

        Queue<Animal> Q= new Queue<>(box);

        Producer p = new Producer(Q);
        ArrayList<Thread> lst=new ArrayList<>();
        Consumer c = new Consumer(Q);
        int n=20000;
        for(int i=0;i<n;i++){
            lst.add(new Thread(p));

        }
        for(int i=0;i<n;i++){
                   lst.add(new Thread(c));
        }
        for(int i=0;i<2*n;i++){
            lst.get(i).start();
        }
        for(int i=0;i<2*n;i++){
            lst.get(i).join();
        }
        System.out.println(p.sum.get());
        assertEquals( p.sum.get(),c.sum.get());
    }
    // Test2 - Queue will have a fixed a capacity, if the capacity is full the producer adding to the queue will be blocked
    // use bounded queue
    @Test
    public void Test2() throws InterruptedException {
        BoxStore store = MyObjectBox.builder().name("objectbox-queue-db2").build();
        Box<Animal> box = store.boxFor(Animal.class);

        Queue<Animal> que= new Queue<>(box,2);

        Integer count = 0;
        Producer p=new Producer(que);
        Thread t1=new Thread(p);
        Thread t2=new Thread(p);
        Thread t3=new Thread(p);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(que);
        assertEquals(true,p.isWasInterrupted());
    }
    //if the queue is empty consumer , reading from the queue will be blocked
    @Test
    public void Test3() throws InterruptedException {
        BoxStore store = MyObjectBox.builder().name("objectbox-queue-db3").build();
        Box<Animal> box = store.boxFor(Animal.class);

        Queue<Animal> que= new Queue<>(box);
        Consumer c=new Consumer(que);
        Producer p=new Producer(que);
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        Thread t3=new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        assertEquals(true,c.isWasInterrupted());
    }
}
