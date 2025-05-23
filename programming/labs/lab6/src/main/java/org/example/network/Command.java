// org.example.network.Command
package org.example.network;

import org.example.util.CollectionManager;
import java.io.Serializable;

public interface Command extends Serializable {
    String execute(CollectionManager collectionManager);
}