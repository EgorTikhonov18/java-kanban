package Manager;

import Tasks.Epic;
import Tasks.Status;
import Tasks.Subtask;
import Tasks.Task;

import java.util.*;

public class InMemoryTaskManager implements TaskManager{
    private  int id = 0;

    private Map<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>(); // тут наверное тоже надо private
    private HashMap<Integer, Epic> epics = new HashMap<>();

    public HistoryManager historyManager = Managers.getDefaultHistory();

    // тут наверное тоже надо private
    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }
    @Override
    public int generateId() {
        return ++id;
    }

    @Override
    public int createTask(Task task) {
        int newTaskId = generateId();
        task.setId(newTaskId);
        tasks.put(newTaskId, task);
        return newTaskId;
    }
    @Override
    public int createEpic(Epic epic) {
        int newEpicId = generateId();
        epic.setId(newEpicId);
        epics.put(newEpicId, epic);
        return newEpicId;
    }
    @Override
    public int createSubtask(Subtask subtask) {
        int newSubtaskId = generateId();
        subtask.setId(newSubtaskId);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            subtasks.put(newSubtaskId, subtask);
            epic.addSubtaskIds(newSubtaskId);
            updateStatusEpic(epic);
            return newSubtaskId;
        } else {
            System.out.println("Tasks.Epic not found");
            return -1;
        }
    }
    @Override
    public void deleteTaskById(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Tasks.Task not found");
        }
    }
    @Override
    public void deleteEpicById(int id) {
        Epic epic = epics.get(id);
        if (epic != null) {
            for (Integer subtaskId : epic.getSubtaskIds()) {
                subtasks.remove(subtaskId);
            }
            epics.remove(id);
        } else {
            System.out.println("Tasks.Epic not found");
        }
    }
    @Override
    public void deleteSubtaskById(int id) {
        Subtask subtask = subtasks.get(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            epic.getSubtaskIds().remove((Integer) subtask.getId());
            updateStatusEpic(epic);
            subtasks.remove(id);
        } else {
            System.out.println("Tasks.Subtask not found");
        }
    }
    @Override
    public void deleteAllTasks() {
        tasks.clear();
    }
    @Override
    public void deleteAllEpics() {
        subtasks.clear();
        epics.clear();
    }
    @Override
    public void deleteAllSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubtaskIds().clear();
            updateStatusEpic(epic);
        }
    }
    @Override
    public Task getTaskById(int id) {
        return tasks.get(id);
    }
    @Override
    public Epic getEpicById(int id) {
        return epics.get(id);
    }
    @Override
    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }
    @Override
    public List<Task> getAllTasks() {
        if (tasks.size() == 0) {
            System.out.println("Tasks.Task list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(tasks.values());
    }
    @Override
    public List<Epic> getAllEpics() {
        if (epics.size() == 0) {
            System.out.println("Tasks.Epic list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(epics.values());
    }
    @Override
    public List<Subtask> getAllSubtasks() {
        if (subtasks.size() == 0) {
            System.out.println("Subtasks list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(subtasks.values());
    }
    @Override
    public List<Subtask> getAllSubtasksByEpicId(int id) {
        if (epics.containsKey(id)) {
            List<Subtask> subtasksNew = new ArrayList<>();
            Epic epic = epics.get(id);
            for (Integer subtaskId : epic.getSubtaskIds()) {
                subtasksNew.add(subtasks.get(subtaskId));
            }
            return subtasksNew;
        } else {
            return Collections.emptyList();
        }
    }
    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Tasks.Task not found");
        }
    }
    @Override
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
            updateStatusEpic(epic);
        } else {
            System.out.println("Tasks.Epic not found");
        }
    }
    @Override
    public void updateStatusEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            if ( epic.getSubtaskIds().isEmpty()) {
                epic.setStatus(Status.NEW);
            } else {
                List<Subtask> subtasksNew = new ArrayList<>();
                int countDone = 0;
                int countNew = 0;


                for (Integer subtaskId : epic.getSubtaskIds()) {
                    Subtask subtask = subtasks.get(subtaskId);
                    switch (subtask.getStatus()) {
                        case DONE:
                            countDone++;
                            break;

                        case NEW:
                            countNew++;

                            break;

                        case IN_PROGRESS:

                            epic.setStatus(Status.IN_PROGRESS);
                            return;
                    }
                }


                if (countDone == epic.getSubtaskIds().size()) {
                    epic.setStatus(Status.DONE);
                } else if (countNew == epic.getSubtaskIds().size()) {
                    epic.setStatus(Status.NEW);
                } else {
                    epic.setStatus(Status.IN_PROGRESS);
                }
            }
        } else {
            System.out.println("Tasks.Epic not found");
        }
    }
    @Override
    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            Epic epic = epics.get(subtask.getEpicId());
            updateStatusEpic(epic);
        } else {
            System.out.println("Tasks.Subtask not found");
        }
    }
    @Override
    public Map<Integer, Task> getTasks() {
        return tasks;
    }
    @Override
    public void setTasks(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }
    @Override
    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }
    @Override
    public void setSubtasks(HashMap<Integer, Subtask> subtasks) {
        this.subtasks = subtasks;
    }
   @Override
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }
    @Override
    public void setEpics(HashMap<Integer, Epic> epics) {
        this.epics = epics;
    }
}
