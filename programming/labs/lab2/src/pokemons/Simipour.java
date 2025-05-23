package pokemons;
import attacks.FocusBlast;


public class Simipour extends Panpour {
    public Simipour(String name, int level) {
        super(name, level);
        super.setStats(75, 98, 63, 98, 63, 101);
        super.addMove(new FocusBlast());
    }
}
