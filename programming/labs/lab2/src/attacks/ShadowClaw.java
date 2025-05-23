package attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class ShadowClaw extends PhysicalMove {
    protected String describe() {
        return "Использовал Shadow Claw";
    }

    public ShadowClaw() {
        super(Type.GHOST, 70, 100);
    }

    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        return 1.8;
    }
}
