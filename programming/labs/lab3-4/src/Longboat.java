import interfaces.Swimable;

public record Longboat(Material material, int weight, double length, int capacity) implements Swimable {
    public void swim() {
        System.out.println("Лодка плывёт");
    }
}

