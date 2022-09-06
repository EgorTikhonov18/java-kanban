package Manager;

import Tasks.Epic;
import Tasks.Subtask;
import Tasks.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TaskManager { // был class
    /*private  int id = 0;

    private Map<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>(); // тут наверное тоже надо private
    private HashMap<Integer, Epic> epics = new HashMap<>();*/ // тут наверное тоже надо private

    // тут наверное тоже надо private
    List<Task> getHistory();

    public int generateId();
        //return ++id;


    public int createTask(Task task) ;
       /* int newTaskId = generateId();
        task.setId(newTaskId);
        tasks.put(newTaskId, task);
        return newTaskId;

        */


    public int createEpic(Epic epic); /*{
        int newEpicId = generateId();
        epic.setId(newEpicId);
        epics.put(newEpicId, epic);
        return newEpicId;
    } */


    public int createSubtask(Subtask subtask); /*{
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
    }*/

    public void deleteTaskById(int id); /*{
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        } else {
            System.out.println("Tasks.Task not found");
        }
    }*/

    public void deleteEpicById(int id); /*{
        Epic epic = epics.get(id);
        if (epic != null) {
            for (Integer subtaskId : epic.getSubtaskIds()) {
                subtasks.remove(subtaskId);
            }
            epics.remove(id);
        } else {
            System.out.println("Tasks.Epic not found");
        }
    }*/

    public void deleteSubtaskById(int id); /*{
        Subtask subtask = subtasks.get(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            epic.getSubtaskIds().remove((Integer) subtask.getId());
            updateStatusEpic(epic);
            subtasks.remove(id);
        } else {
            System.out.println("Tasks.Subtask not found");
        }
    }*/

    public void deleteAllTasks(); /*{
        tasks.clear();
    }*/

    public void deleteAllEpics(); /*{
        subtasks.clear();
        epics.clear();
    }*/

    public void deleteAllSubtasks();/* {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubtaskIds().clear();
            updateStatusEpic(epic);
        }
    }*/

    public Task getTaskById(int id); /*{
        return tasks.get(id);
    }*/

    public Epic getEpicById(int id); /*{
        return epics.get(id);
    }*/

    public Subtask getSubtaskById(int id); /*{
        return subtasks.get(id);
    }*/

    public List<Task> getAllTasks(); /*{
        if (tasks.size() == 0) {
            System.out.println("Tasks.Task list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(tasks.values());
    }*/

    public List<Epic> getAllEpics(); /*{
        if (epics.size() == 0) {
            System.out.println("Tasks.Epic list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(epics.values());
    }*/

    public List<Subtask> getAllSubtasks(); /*{
        if (subtasks.size() == 0) {
            System.out.println("Subtasks list is empty");
            return Collections.emptyList();
        }
        return new ArrayList<>(subtasks.values());
    }*/

    public List<Subtask> getAllSubtasksByEpicId(int id); /*{
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
    }*/

    public void updateTask(Task task); /*{
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Tasks.Task not found");
        }
    }*/

    public void updateEpic(Epic epic); /*{
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
            updateStatusEpic(epic);
        } else {
            System.out.println("Tasks.Epic not found");
        }
    }*/

    public void updateStatusEpic(Epic epic); /*{
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
    }*/

    public void updateSubtask(Subtask subtask); /*{
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            Epic epic = epics.get(subtask.getEpicId());
            updateStatusEpic(epic);
        } else {
            System.out.println("Tasks.Subtask not found");
        }
    }*/

    public Map<Integer, Task> getTasks(); /*{
        return tasks;
    }*/

    public void setTasks(Map<Integer, Task> tasks); /*{
        this.tasks = tasks;
    }*/

    public HashMap<Integer, Subtask> getSubtasks(); /*{
        return subtasks;
    }*/

    public void setSubtasks(HashMap<Integer, Subtask> subtasks); /*{
        this.subtasks = subtasks;
    }*/

    public HashMap<Integer, Epic> getEpics(); /*{
        return epics;
    }*/

    public void setEpics(HashMap<Integer, Epic> epics); /*{
        this.epics = epics;
    }*/
}

