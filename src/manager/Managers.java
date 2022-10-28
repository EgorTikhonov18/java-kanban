package manager;


import manager.inMemory.InMemoryHistoryManager;
import manager.inMemory.InMemoryTaskManager;
import manager.interfaces.HistoryManager;
import manager.interfaces.TaskManager;

public class Managers {
    public static TaskManager getInMemoryTaskManager(HistoryManager historyManager) {
        return new InMemoryTaskManager(historyManager);
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}

