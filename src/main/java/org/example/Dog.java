package org.example;

import io.objectbox.annotation.Entity;

@Entity
public class Dog extends Animal{
    private int noOfTeeth;

    public Dog(long id, int age, char gender, int noOfTeeth) {
        super(id, age, gender);
        this.noOfTeeth = noOfTeeth;
    }

    public Dog(int age, char gender, int noOfTeeth) {
        super(age, gender);
        this.noOfTeeth = noOfTeeth;
    }

    public Dog(int noOfTeeth) {
        this.noOfTeeth = noOfTeeth;
    }

    public Dog(){
        noOfTeeth = 0;
    }

    public int getNoOfTeeth() {
        return noOfTeeth;
    }

    public void setNoOfTeeth(int noOfTeeth) {
        this.noOfTeeth = noOfTeeth;
    }

    public void showData(){
        System.out.println("----------------------------------------");
        System.out.println("Dog Details : ");
        super.showData();
        System.out.println("No of Teeth : " + this.getNoOfTeeth());
        System.out.println("----------------------------------------");
    }
}
