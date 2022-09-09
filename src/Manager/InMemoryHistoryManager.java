package Manager;

import Tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final static int LIST_SIZE = 10;
    private final List<Task> listHistory = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (task != null) {
            listHistory.add(task);
        }
        if (listHistory.size() == LIST_SIZE) {
            listHistory.remove(0);
        }
    }

    @Override
    public List<Task> getHistory() {
        return listHistory;
    }
}