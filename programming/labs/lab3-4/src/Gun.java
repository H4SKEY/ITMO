import exceptions.IllegalGunCapacity;
import interfaces.Firearms;

public class Gun implements Firearms {
    private int capacity;
    private int bulletNow;

    public void shoot() {
        if (bulletNow < 1) {
            System.out.println("Закончились патроны");
        }

        else {
            bulletNow -= 1;
            System.out.println("Ружье выстрелило");
        }
    }

    public void reload() {
        this.bulletNow = capacity;
        System.out.println("Ружье перезаряжено");
    }

    public Gun() {
        this.capacity = 5;
        this.bulletNow = 5;
    }

    public Gun(int capacity, int bulletNow) {
        try {
            setCapacity(capacity);
            setBulletNow(bulletNow);
        }

        catch (IllegalGunCapacity e) {
            System.err.println("Применён конструктор по умолчанию");
            this.capacity = 5;
            this.bulletNow = 5;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) throws IllegalGunCapacity {
        if (capacity > 0) {
            this.capacity = capacity;
        }

        else {
            throw new IllegalGunCapacity();
        }
    }

    public int getBulletNow() {
        return bulletNow;
    }

    public void setBulletNow(int bulletNow) {
        if (bulletNow < 0 || bulletNow > this.capacity) {
            this.bulletNow = this.capacity;
        }

        else {
            this.bulletNow = bulletNow;
        }
    }
}
