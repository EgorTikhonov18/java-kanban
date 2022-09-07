import Tasks.Task;
import Tasks.Status;
import Tasks.sub.Epic;
import Tasks.sub.SubTask;
import Manager.*;

public class Main {
    public static void main(String[] args) {

        TaskManager inMemoryTaskManager = Managers.getDefault();

        inMemoryTaskManager.createTask(new Task("Таск 1", Status.NEW, "Доделать тз"));
        inMemoryTaskManager.createTask(new Task("Таск 2", Status.NEW, "Сдать тз"));
        inMemoryTaskManager.createTask(new Task("Таск 3", Status.NEW, "Не улететь в академ"));
        inMemoryTaskManager.createTask(new Task("Таск 4", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 5", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 6", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 7", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 8", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 9", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 10", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 11", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 12", Status.NEW, "Купить еды"));
        inMemoryTaskManager.createTask(new Task("Таск 13", Status.NEW, "Купить еды"));

        inMemoryTaskManager.createEpic(new Epic("Эпик 1", Status.NEW, "Покупка квартиры"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 2", Status.NEW, "Продажа дачи"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 3", Status.NEW, "Покупка квартиры"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 4", Status.NEW, "Продажа дачи"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 5", Status.NEW, "Покупка квартиры"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 6", Status.NEW, "Продажа дачи"));

        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 1", Status.NEW, "Посмотреть комнату", 15));
        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 2", Status.NEW, " Посмотреть комнату", 15));
        inMemoryTaskManager.addSubTask(new SubTask("Сабтаск 3", Status.NEW, " Посмотреть комнату", 16));


        for (int i = 1; i <= 13; i++) {
            inMemoryTaskManager.getTaskByID(i);
        }
        for (int i = 14; i <= 18; i++) {
            inMemoryTaskManager.getEpicByID(i);
        }
        inMemoryTaskManager.getTaskByID(4);
        inMemoryTaskManager.getSubtaskByID(20);
        inMemoryTaskManager.getSubtaskByID(21);
        inMemoryTaskManager.getTaskByID(9);
        inMemoryTaskManager.getSubtaskByID(22);

        System.out.println(inMemoryTaskManager.getHistory());
    }
}
 /*   inMemoryTaskManager.addSubTask(new SubTask("Подать объявление", Status.NEW, "Разместить объявление в газете", 3));
        inMemoryTaskManager.addSubTask(new SubTask("Подписать договор", Status.NEW, "Заключить договор", 3));
        inMemoryTaskManager.addSubTask(new SubTask("Найти покупателя", Status.NEW, "Подписать договор с риэлтором", 4));
        // inMemoryTaskManager.deleteAllTasks();
        //     inMemoryTaskManager.deleteSubtaskById(6);
        //     inMemoryTaskManager.deleteAllEpics();
        //   inMemoryTaskManager.deleteEpicById(3);
        // System.out.println(inMemoryTaskManager.getTasks());
        //      inMemoryTaskManager.updateTask(new Task("Учеба", Status.IN_PROGRESS, "Доделать тз"));
        inMemoryTaskManager.updateEpic(new Epic("Квартира", Status.IN_PROGRESS, "Приобретение квартиры"));
        inMemoryTaskManager.updateSubtask(new SubTask("Подать объявление", Status.DONE, "Разместить объявление в газете", 3));
        inMemoryTaskManager.updateSubtask(new SubTask("Подписать договор", Status.DONE, "Заключить договор", 3));
        inMemoryTaskManager.updateSubtask(new SubTask("Найти покупателя", Status.DONE, "Подписать договор с риэлтором", 4));
        inMemoryTaskManager.addSubTask(new SubTask("Документы в МФЦ", Status.IN_PROGRESS, "Отдать документы в МФЦ", 3));
      inMemoryTaskManager.deleteSubtaskById(5);
      inMemoryTaskManager.updateSubtask(new SubTask("Подписать договор", Status.IN_PROGRESS, "Заключить договор", 3));
       System.out.println(inMemoryTaskManager.getEpics());
       System.out.println(inMemoryTaskManager.getAllSubtasks()); */