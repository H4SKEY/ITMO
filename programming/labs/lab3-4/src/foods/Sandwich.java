package foods;

public class Sandwich extends Food {
    @Override
    public void smells() {
        System.out.println("Пахнет вкусно");;
    }

    public Sandwich() {
        super();
    }

    public Sandwich(String name, double proteins, double fats, double carbohydrates, double calorie, int weight) {
        super(name, proteins, fats, carbohydrates, calorie, weight);
    }
}
