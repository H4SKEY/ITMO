package org.example.data;

/**
 * Класс, представляющий координаты
 */
public class Coordinates {
    private long x;
    private long y; //Максимальное значение поля: 166

    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры и сеттеры
    public long getX() { return x; }
    public long getY() { return y; }

    public void setX(long x) { this.x = x; }
    public void setY(long y) {
        if (y > 166) throw new IllegalArgumentException("Y coordinate must be <= 166");
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}