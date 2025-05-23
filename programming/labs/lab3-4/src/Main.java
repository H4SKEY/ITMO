import exceptions.IllegalGunCapacity;
import foods.Fish;
import foods.Food;
import foods.Sandwich;
import persons.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        try {
            System.out.println(persons.get(100));
        }

        catch (IndexOutOfBoundsException e) {
            System.err.println("Не удалось найти элемент");
        }

        Moor moor1 = new Moor("Андрей", 180, 32, 90, Gender.MALE);
        persons.add(moor1);

        Angler angler1 = new Angler("Лёха", 140, 56, 90, Gender.MALE);
        persons.add(angler1);

        MainHero mainHero1 = new MainHero("Антоха", 175, 19, 79, Gender.MALE);
        persons.add(mainHero1);

        Gun gun = new Gun(10, 5);

        try {
            gun.setCapacity(-10);
        }

        catch (IllegalGunCapacity e) {
            System.err.println("Установлено значение по умолчанию");
        }

        Longboat longboat = new Longboat(Material.WOOD, 120, 2, 3);
        Food food = new Sandwich("Сендвич", 12.5, 10.3, 9.8, 13.4, 100);


        for (int i = 0; i < persons.toArray().length; i++) {
            persons.get(i).say();
        }

        angler1.fish();
        Fish fish = new Fish();
        angler1.eat(fish);

        gun.shoot();
        gun.reload();

        System.out.println(longboat.material());
        System.out.println(food.getCalorie());
    }
}




