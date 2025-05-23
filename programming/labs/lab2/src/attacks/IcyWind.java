package attacks;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class IcyWind extends SpecialMove {
    protected String describe() {
        return "Использовал Icy Wind";
    }

    public IcyWind() {
        super(Type.ICE, 55, 95);
    }

    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -1);
    }
}
