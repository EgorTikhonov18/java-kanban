package Manager;

import Manager.inMemory.InMemoryHistoryManager;
import Manager.inMemory.InMemoryTaskManager;
import Manager.interfaces.HistoryManager;
import Manager.interfaces.TaskManager;
import Manager.inFile.FileBackedTasksManager;

import java.io.File;

public class Managers {
    private static TaskManager taskManager;
    private static HistoryManager historyManager;

    static {
        historyManager = new InMemoryHistoryManager();
        taskManager = new FileBackedTasksManager(new File("src/Manager/InFile/saveNotes2.csv"));
    }
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
