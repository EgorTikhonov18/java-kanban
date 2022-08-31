import Manager.Manager;
import Tasks.Epic;
import Tasks.Status;
import Tasks.Subtask;
import Tasks.Task;

import java.util.List;


public class Main {
    static Manager manager = new Manager();

    public static void main(String[] args) {


        System.out.println("~~ Задача ~~");
        System.out.println("--- Создайте задачу ---");
        manager.createTask(new Task("Описание-1", "Tasks.Task-1", Status.NEW));
        manager.createTask(new Task("Описание-2", "Tasks.Task-2", Status.NEW));
        printTasks();
        System.out.println("--- Получите все задачи---");
        List<Task> taskList = manager.getAllTasks();
        System.out.println(taskList);
        System.out.println("--- Получить задачу по id ---");
        Task task = manager.getTaskById(1);
        System.out.println(task);
        System.out.println("--- Обновить задачу---");
        task.setStatus(Status.IN_PROGRESS);
        manager.updateTask(task);
        System.out.println(task);
        System.out.println();

        System.out.println("!!! Tasks.Epic !!!");
        System.out.println("--- Создать эпик ---");
        manager.createEpic(new Epic("Описание-1", "Tasks.Epic-1"));
        manager.createEpic(new Epic("Описание-2", "Tasks.Epic-2" ));
        printEpics();
        System.out.println("--- Получить все эпики --");
        List<Epic> epics = manager.getAllEpics();
        System.out.println(epics);
        System.out.println("--- Получить эпик по id ---");
        Epic epic = manager.getEpicById(3);
        System.out.println(epic);
        System.out.println("--- Обновить Эпик ---");
        epic.setStatus(Status.IN_PROGRESS);
        manager.updateEpic(epic);
        System.out.println(epic);
        System.out.println();

        System.out.println(">>> Подзадача ");
        System.out.println("--- Создать подзадачу ---");
        manager.createSubtask(new Subtask("Описание-1", "Tasks.Subtask-1", Status.NEW, 3));
        manager.createSubtask(new Subtask("Описание-2", "Tasks.Subtask-2", Status.NEW, 3));
        manager.createSubtask(new Subtask("Описание-3", "Tasks.Subtask-3", Status.NEW, 4));
        manager.createSubtask(new Subtask("Описание-4", "Tasks.Subtask-4", Status.NEW, 4));
        printSubtasks();
        System.out.println("--- Получить все подзадачи по id эпика  ---");
        List<Subtask> subtasksByEpicId = manager.getAllSubtasksByEpicId(3);
        System.out.println(subtasksByEpicId);
        System.out.println("--- Получить все подзадачи ---");
        List<Subtask> subtasks = manager.getAllSubtasks();
        System.out.println(subtasks);
        System.out.println("---  Получить подзадачу по id ---");
        Subtask subtask = manager.getSubtaskById(5);
        System.out.println(subtask);
        System.out.println("--- Обновить подзадачу ---");
        subtask.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(subtask);
        System.out.println(subtask);
        System.out.println();

        System.out.println("*** Удаление ***");
        System.out.println("--- Удалить задачу по id ---");
        manager.deleteTaskById(1);
        System.out.println(taskList);
        System.out.println("--- Удалить все задачи ---");
        manager.deleteAllTasks();
        printTasks();
        System.out.println("--- удалить подзадачу по id ---");
        manager.deleteSubtaskById(5);
        printSubtasks();
        System.out.println("--- удалить все подзадачи ---");
        manager.deleteAllSubtasks();
        printSubtasks();
        System.out.println("--- Удалить эпик по id ---");
        manager.deleteEpicById(4);
        printEpics();
        System.out.println("--- Удалить все эпики ---");
        manager.deleteAllEpics();
        printEpics();


    }

    public static void printTasks() {
        if (manager.getTasks().size() == 0) {
            System.out.println("Tasks.Task list is empty");
            return;
        }
        for (Task task : manager.getTasks().values()) {
            System.out.println("Tasks.Task{" +
                    "description='" + task.getDescription() + '\'' +
                    ", id=" + task.getId() +
                    ", name='" + task.getName() + '\'' +
                    ", status=" + task.getStatus() +
                    '}');
        }
    }

    public static void printEpics() {
        if (manager.getEpics().size() == 0) {
            System.out.println("Tasks.Epic list is empty");
            return;
        }
        for (Epic epic : manager.getEpics().values()) {
            System.out.println("Tasks.Epic{" +
                    "subtasksIds=" + epic.getSubtaskIds() +
                    ", description='" + epic.getDescription() + '\'' +
                    ", id=" + epic.getId() +
                    ", name='" + epic.getName() + '\'' +
                    ", status=" + epic.getStatus() +
                    '}');
        }
    }

    public static void printSubtasks() {
        if (manager.getSubtasks().size() == 0) {
            System.out.println("Tasks.Subtask list is empty");
            return;
        }
        for (Subtask subtask : manager.getSubtasks().values()) {
            System.out.println("Tasks.Subtask{" +
                    "epicId=" + subtask.getEpicId() +
                    ", description='" + subtask.getDescription() + '\'' +
                    ", id=" + subtask.getId() +
                    ", name='" + subtask.getName() + '\'' +
                    ", status=" + subtask.getStatus() +
                    '}');
        }
    }
}
