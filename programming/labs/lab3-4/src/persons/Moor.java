package persons;

import foods.Food;

public class Moor extends Person {
    @Override
    public void eat(Food food) {
        System.out.println(getName() + " насытился " + food.getName());
        setWeight(getWeight() + food.getWeight() / 100);
    }

    public void say() {
        System.out.println("Ура, поймали!");
    }

    public Moor() {
        super();
    }

    public Moor(String name, double height, int age, int weight, Gender gender) {
        super(name, height, age, weight, gender);
    }
}
