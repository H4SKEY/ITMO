package attacks;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DoubleHit extends PhysicalMove {
    protected String describe() {
        return "Использовал Double Hit";
    }

    public DoubleHit() {
        super(Type.NORMAL, 35, 90);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage * 2);
    }
}
