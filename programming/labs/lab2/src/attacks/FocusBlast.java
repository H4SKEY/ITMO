package attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class FocusBlast extends SpecialMove {
    protected String describe() {
        return "Использовал Focus Blast";
    }

    public FocusBlast() {
        super(Type.FIGHTING, 120, 70);
    }

    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            p.setMod(Stat.DEFENSE, -1);
        }
    }
}
