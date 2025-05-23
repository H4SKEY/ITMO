import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Dunsparce("Dunsparce", 1);
        Pokemon p2 = new Swinub("Swinub", 1);
        Pokemon p3 = new Panpour("Panpour", 1);
        Pokemon p4 = new Simipour("Simipour", 1);
        Pokemon p5 = new Piloswine("Piloswine", 1);
        Pokemon p6 = new Mamoswine("Mamoswine", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();
    }
}


