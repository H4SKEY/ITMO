package persons;

import foods.Food;
import interfaces.Eatable;
import interfaces.Sayable;

public abstract class Person implements Eatable, Sayable {
    private String name;
    private double height;
    private int age;
    private int weight;
    private Gender gender;

    public Person() {
        this.name = "Антон";
        this.height = 175.5;
        this.age = 19;
        this.weight = 79;
        this.gender = Gender.MALE;
    }

    public abstract void eat(Food food);

    public void say() {
        System.out.println("Пойдем на рыбалку");
    }
    
    public Person(String name, double height, int age, int weight, Gender gender) {
        this.name = name;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }

        else {
            this.age = 1;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Имя: " + getName();
    }

    @Override
    public int hashCode() {
        int hashNum = 0;

        if (name != null) {
            hashNum = name.hashCode();
        }

        hashNum = 31 * hashNum + (int) height * 100;
        hashNum = 31 * hashNum + age;
        hashNum = 31 * hashNum + weight;
        hashNum = 31 * hashNum;

        switch (gender) {
            case MALE: {
                hashNum += 1;
                break;
            }

            case FEMALE: {
                hashNum += 2;
                break;
            }
        }

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

        Person person = (Person) obj;

        if (age != person.age) {
            return false;
        }

        if (height != person.height) {
            return false;
        }

        if (weight != person.weight) {
            return false;
        }

        if (!gender.equals(person.gender)) {
            return false;
        }

        return name.equals(person.name);
    }
}













