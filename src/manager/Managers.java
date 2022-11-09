package manager;


import http.HTTPTaskManager;
import http.KVServer;
import manager.HistoryAndTaskManagerInterfaces.HistoryManager;
import manager.HistoryAndTaskManagerInterfaces.TaskManager;
import manager.inMemory.InMemoryHistoryManager;
import manager.inMemory.InMemoryTaskManager;

import java.io.IOException;

public class Managers {
    public static TaskManager getInMemoryTaskManager(HistoryManager historyManager) {
        return new InMemoryTaskManager(historyManager);
    }

    public static HTTPTaskManager getDefault(HistoryManager historyManager) throws IOException, InterruptedException {
        return new HTTPTaskManager(historyManager, "http://localhost:" + KVServer.PORT);
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
