package attacks;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove {
    protected String describe() {
        return "Использовал FACADE";
    }

    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        if (def.getCondition() == Status.BURN || def.getCondition() == Status.POISON || def.getCondition() == Status.PARALYZE) {
            super.applyOppDamage(def, damage * 2);
        }
    }
}
