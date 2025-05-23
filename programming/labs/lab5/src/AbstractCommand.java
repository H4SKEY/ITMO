public abstract class AbstractCommand {
    protected final CollectionManager collectionManager;
    protected final InputManager inputManager;

    public AbstractCommand(CollectionManager collectionManager, InputManager inputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    public abstract void execute(String[] args);
}