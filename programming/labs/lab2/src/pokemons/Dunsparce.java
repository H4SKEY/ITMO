package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.Pokemon;

public class Dunsparce extends Pokemon {
    public Dunsparce(String name, int level) {
        super(name, level);
        super.setStats(100, 70, 70, 65, 65, 45);
        super.addMove(new Facade());
        super.addMove(new Bulldoze());
        super.addMove(new ThunderWave());
        super.addMove(new Headbutt());
    }
}
