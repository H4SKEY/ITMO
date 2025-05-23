package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class RockTomb extends PhysicalMove {
    protected String describe() {
        return "Использовал Rock Tomb";
    }

    public RockTomb() {
        super(Type.ROCK, 60, 95);
    }

    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -1);
    }
}
