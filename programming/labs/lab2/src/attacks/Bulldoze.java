package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Bulldoze extends PhysicalMove {
    protected String describe() {
        return "Использовал Bulldoze";
    }

    public Bulldoze() {
        super(Type.GROUND, 60,  100);
    }

    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -1);
    }
}
