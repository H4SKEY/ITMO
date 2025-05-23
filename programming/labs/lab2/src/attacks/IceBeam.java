package attacks;
import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove {
    protected String describe() {
        return "Использовал Ice Beam";
    }

    public IceBeam() {
        super(Type.ICE, 90, 100);
    }

    protected void 	applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1) {
            Effect.freeze(p);
        }
    }
}
