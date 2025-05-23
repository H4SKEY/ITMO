package pokemons;

import attacks.DoubleHit;

public class Mamoswine extends Piloswine {
    public Mamoswine (String name, int level) {
        super(name, level);
        super.setStats(110, 130, 80, 70, 60, 80);
        super.addMove(new DoubleHit());
    }
}
