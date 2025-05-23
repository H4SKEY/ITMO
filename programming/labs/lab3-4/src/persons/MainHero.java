package persons;

import foods.Food;

public class MainHero extends Person {
    @Override
    public void eat(Food food) {
        System.out.println(getName() + " насытился " + food.getName());
        setWeight(getWeight() + food.getWeight() / 100);
    }

    public void say() {
        System.out.println("Какая большая рыба!");
    }

    public MainHero() {
        super();
    }

    public MainHero(String name, double height, int age, int weight, Gender gender) {
        super(name, height, age, weight, gender);
    }
}
