package persons;

import foods.Food;
import interfaces.Fishable;

public class Angler extends Person implements Fishable {
    @Override
    public void eat(Food food) {
        System.out.println(getName() + " насытился " + food.getName());
        setWeight(getWeight() + food.getWeight() / 100);
    }

    public void say() {
        System.out.println("Я поймал рыбу");
    }

    public void fish() {
        System.out.println(getName() + " ловит рыбу");
    }

    public Angler() {
        super();
    }

    public Angler(String name, double height, int age, int weight, Gender gender) {
        super(name, height, age, weight, gender);
    }
}
