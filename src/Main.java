import Manager.Managers;
import Manager.TaskManager;
import Tasks.*;
import Tasks.sub.Epic;
import Tasks.sub.SubTask;

public class Main {
    public static void main(String[] args) {

        TaskManager inMemoryTaskManager = Managers.getDefault();

        inMemoryTaskManager.createTask(new Task("Задача 1", Status.NEW, "Сесть за ТЗ"));
        inMemoryTaskManager.createTask(new Task("Задача 2", Status.NEW, "Сдать ТЗ"));


        inMemoryTaskManager.createEpic(new Epic("Эпик 1", Status.NEW, "Просмотреть сериал"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 2", Status.NEW, "Почитать книгу"));

        inMemoryTaskManager.addSubTask(new SubTask("Подзадача 1", Status.NEW, "досмотреть 1 серию", 1));
        inMemoryTaskManager.addSubTask(new SubTask("Подзадача 2", Status.NEW, "начать смотреть 2 серию", 2));
        inMemoryTaskManager.addSubTask(new SubTask("Подзадача 3", Status.NEW, "не забыть про 3 серию", 3));


        inMemoryTaskManager.getTaskByID(2);
        inMemoryTaskManager.getTaskByID(1);
        inMemoryTaskManager.getTaskByID(1);
        inMemoryTaskManager.getTaskByID(2);

    /*    inMemoryTaskManager.getEpicByID(1);
        inMemoryTaskManager.getSubtaskByID(3); вылетают exception'ы
        inMemoryTaskManager.getSubtaskByID(2);
        inMemoryTaskManager.getSubtaskByID(1);
        inMemoryTaskManager.deleteEpicById(1);

     */

        System.out.println(inMemoryTaskManager.getHistory());
    }
}
