/**
 * Команда очистки коллекции
 */
public class ClearCommand extends AbstractCommand {
    public ClearCommand(CollectionManager collectionManager, InputManager inputManager) {
        super(collectionManager, inputManager);
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
        System.out.println("Коллекция очищена");
    }
}