/**
 * Команда реверса коллекции
 */
public class ReorderCommand extends AbstractCommand {
    public ReorderCommand(CollectionManager collectionManager, InputManager inputManager) {
        super(collectionManager, inputManager);
    }

    @Override
    public void execute(String[] args) {
        collectionManager.reorder();
        System.out.println("Коллекция отсортирована в обратном порядке");
    }
}