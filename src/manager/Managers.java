package manager;


import manager.inMemory.InMemoryHistoryManager;
import manager.inMemory.InMemoryTaskManager;
import manager.HistoryAndTaskManagerInterfaces.HistoryManager;
import manager.HistoryAndTaskManagerInterfaces.TaskManager;

public class Managers {
    public static TaskManager getInMemoryTaskManager(HistoryManager historyManager) {
        return new InMemoryTaskManager(historyManager);
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}

