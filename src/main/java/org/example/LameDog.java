package org.example;

import io.objectbox.annotation.Entity;

@Entity
public class LameDog extends Animal{
    private int noOfLegs;

    public LameDog(long id, int age, char gender, int noOfLegs) {
        super(id, age, gender);
        this.noOfLegs = noOfLegs;
    }

    public LameDog(int age, char gender, int noOfLegs) {
        super(age, gender);
        this.noOfLegs = noOfLegs;
    }

    public LameDog(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public LameDog(){
        noOfLegs = 0;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void showData(){
        System.out.println("----------------------------------------");
        System.out.println("Dog Details : ");
        super.showData();
        System.out.println("No of Teeth : " + this.getNoOfLegs());
        System.out.println("----------------------------------------");
    }
}
