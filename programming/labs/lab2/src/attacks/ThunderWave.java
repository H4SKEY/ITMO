package attacks;

import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove {
    protected String describe() {
        return "Использовал Thunder Wave";
    }

    public ThunderWave() {
        super(Type.ELECTRIC, 0, 90);
    }

    protected void applyOppEffects(Pokemon p) {
        Effect.paralyze(p);
    }
}
