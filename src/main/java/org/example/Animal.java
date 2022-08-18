package org.example;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Animal {

    @Id(assignable = true)
    public long id;
    private Integer age;
    private char gender;

    public Animal(long id, Integer age, char gender){
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public Animal(Integer age, char gender){
        this.age = age;
        this.gender = gender;
    }

    public Animal(){
        id = 0;
        age = null;
        gender = '\0';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void showData(){
        System.out.println("-------------------------");
        System.out.println("Age : " + this.getAge());
        System.out.println("Gender : " + this.getGender());
        System.out.println("-------------------------");
    }
}
