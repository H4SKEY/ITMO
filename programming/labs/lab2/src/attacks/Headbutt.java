package attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Headbutt extends PhysicalMove {
    protected String describe() {
        return "Использовал Headbutt";
    }

    public Headbutt() {
        super(Type.NORMAL, 70, 100);
    }

    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3) {
            Effect.flinch(p);
        }
    }
}
