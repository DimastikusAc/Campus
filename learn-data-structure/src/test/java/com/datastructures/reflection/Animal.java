package com.datastructures.reflection;

public class Animal {

    public Animal() {
        System.out.println("Animal created");
    }

    public void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }
}

interface Trained {
    void doSit();
}

interface Play{
    void play();
}

class Chihuahua extends Dog implements Trained, Play {
    @Override
    public void doSit() {
        System.out.println("Chihuahua sits");
    }
    @Override
    public void play() {
        System.out.println("Playing with owner");
    }
}