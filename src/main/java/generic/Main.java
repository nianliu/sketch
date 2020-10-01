package generic;

import com.google.common.collect.Lists;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = Lists.newArrayList(new Dog(), new Tiger(), new Feline());
        List<Feline> felines = Lists.newArrayList(new Feline(), new Tiger());
        List<Dog> dogs = Lists.newArrayList(new Dog(), new Animal());
//        nonCovariantFn(felines); // List<T> generic type is not covariant
//        nonCovariantFn(dogs);
        covariantFn(felines);
        covariantFn(dogs);
    }

    // 1. you cannot call this function with subtypes of Animal
    static void nonCovariantFn(List<Animal> animals) {
        animals.forEach(Animal::breathe);
        animals.add(new Tiger()); // 2. because otherwise you could add wrong type, e.g. add tiger to dog list
    }


    // `extends` makes this fn covariant, the list becomes a producer, you can read from it, but not write to it
    static void covariantFn(List<? extends Animal> animals) {
        animals.forEach(Animal::breathe);
        animals.get(0).breathe();
//        animals.add(new Tiger());
        animals.add(new Animal());
    }

    static void contraVariantFn(List<? super Feline> atLeastTiger) {
        Object object = atLeastTiger.get(0); // you cannot know the what object you expect
        List<? super Feline> atLeastTiger1 = atLeastTiger;
        atLeastTiger.add(new Tiger());
        atLeastTiger.add(new Feline());
        atLeastTiger.add(new Animal());

    }


}
