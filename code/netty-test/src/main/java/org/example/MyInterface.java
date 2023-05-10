package org.example;

public interface MyInterface {
    default String getName(){
        return "default interface method";
    }

    static Integer getAge(){
        return 18;
    }
}


