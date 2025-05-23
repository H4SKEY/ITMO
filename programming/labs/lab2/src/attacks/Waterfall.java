package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Waterfall extends PhysicalMove {
    protected String describe() {
        return "Использовал Waterfall";
    }

    public Waterfall() {
        super(Type.WATER, 80, 100);
    }

    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.2) {
            Effect.flinch(p);
        }
    }
}
