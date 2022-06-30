package day09.training;

import java.util.*;

public class AnimalCage {

    void addToNewCat(List<? super Cat> cats) {
        cats.add(new Cat());
    }

    public void tryAddCat() {
        List<Cat> cats = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Object> objs = new ArrayList<>();
        List<Tiger> tigers = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();

        addToNewCat(cats);      // <Cat>
        addToNewCat(animals);   // <Animal>
        addToNewCat(objs);      // <Object>
//        addNewCat(tigers);  // 컴파일 오류
//        addToNewCat(dogs);  // 컴파일 오류
    }

    public void cage() {
        Cage<Dog> dogCage = new Cage<>();
        dogCage.add(new Dog());
        Dog dog1 = dogCage.get();
        System.out.println(dog1);

        Cage<Cat> catCage = new Cage<>();
        catCage.add(new Cat());
        Cat cat1 = catCage.get();
        System.out.println(cat1);
//         catCage.add(new Dog());  // 컴파일 오류
//         Cage<String> stringCage = new Cage<>(); // 컴파일 오류

        Cage<Animal> animalCage = new Cage<>();
        animalCage.add(new Dog());  // Dog도 가능하고,
        animalCage.add(new Cat());  // Cat도 가능

        // foreach를 돌릴려면 Iterable 인터페이스를 구현해야해요.
        for(Animal animal : animalCage){
            System.out.println("animalCage 돌아가유 : "+animal);
        }

        Animal animal1 = animalCage.get();
        Animal animal2 = animalCage.get();

        // foreach를 돌릴려면 Iterable 인터페이스를 구현해야해요.
        for(Animal animal : animalCage){
            System.out.println("animalCage 돌아가유 : "+animal);
        }

        System.out.println(animal1);
        System.out.println(animal2);
    }

    public static void main(String[] args) {
        AnimalCage ex = new AnimalCage();
        ex.cage();
//        ex.tryAddCat();
    }
}

abstract class Animal {
    public abstract void cry();
}
class Dog extends Animal {
    @Override
    public void cry() {
        System.out.println("Woof!");
    }
}
class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("Nyan~");
    }
}
class Tiger extends Cat {
    public void cry() {
        System.out.println("Grrr~");
    }
}

class Cage<T extends Animal> implements Iterable<T> {  // Bounded Type Parameter
    private Stack<T> animals = new Stack<>();

    public void add(T animal) {
        animals.push(animal);
    }

    public T get() {
        return animals.pop();
    }

    public Stack<T> getAnimals() {
        return animals;
    }

    @Override
    public Iterator<T> iterator() {
        return getAnimals().iterator();
    }
}