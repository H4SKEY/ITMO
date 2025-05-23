package foods;

import interfaces.Smellable;
import persons.Person;

public abstract class Food implements Smellable {
    private String name;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private double calorie;
    private int weight;

    public Food() {
        this.name = "Рыба";
        this.proteins = 20;
        this.fats = 40;
        this.carbohydrates = 30;
        this.calorie = 500.5;
        this.weight = 1;
    }

    public abstract void smells();

    public Food(String name, double proteins, double fats, double carbohydrates, double calorie, int weight) {
        this.name = name;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.calorie = calorie;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Калории: " + getCalorie();
    }

    @Override
    public int hashCode() {
        int hashNum = 0;

        if (name != null) {
            hashNum = name.hashCode();
        }

        hashNum = 31 * hashNum + (int) proteins * 100;
        hashNum = 31 * hashNum + (int) fats * 100;
        hashNum = 31 * hashNum + (int) carbohydrates * 100;
        hashNum = 31 * hashNum + (int) calorie * 100;
        hashNum = 31 * hashNum + weight;

        return hashNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Food food = (Food) obj;

        if (proteins != food.proteins) {
            return false;
        }

        if (fats != food.fats) {
            return false;
        }

        if (carbohydrates != food.carbohydrates) {
            return false;
        }

        if (calorie != food.calorie) {
            return false;
        }

        if (weight != food.weight) {
            return false;
        }

        return name.equals(food.name);
    }
}


