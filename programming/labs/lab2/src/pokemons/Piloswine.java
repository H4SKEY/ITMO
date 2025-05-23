package pokemons;

import attacks.IcyWind;

public class Piloswine extends Swinub {
    public Piloswine (String name, int level) {
        super(name, level);
        super.setStats(100, 100, 80, 60, 60, 50);
        super.addMove(new IcyWind());
    }
}
