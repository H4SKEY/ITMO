package pokemons;

import attacks.RockTomb;
import attacks.ShadowClaw;
import attacks.Waterfall;
import ru.ifmo.se.pokemon.Pokemon;

public class Panpour extends Pokemon {
    public Panpour(String name, int level) {
        super(name, level);
        super.setStats(50, 53, 48, 53, 48, 64);
        super.addMove(new RockTomb());
        super.addMove(new Waterfall());
        super.addMove(new ShadowClaw());
    }
}
