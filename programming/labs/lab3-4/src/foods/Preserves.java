package foods;

public class Preserves extends Food {
    @Override
    public void smells() {
        System.out.println("Пахнет прекрасно");;
    }

    public Preserves() {
        super();
    }

    public Preserves(String name, double proteins, double fats, double carbohydrates, double calorie, int weight) {
        super(name, proteins, fats, carbohydrates, calorie, weight);
    }
}
