package foods;

public class Fish extends Food {
    @Override
    public void smells() {
        System.out.println("Пахнет необычно");;
    }

    public Fish() {
        super();
    }

    public Fish(String name, double proteins, double fats, double carbohydrates, double calorie, int weight) {
        super(name, proteins, fats, carbohydrates, calorie, weight);
    }
}
