import Manager.Managers;
import Manager.TaskManager;
import Tasks.Epic;
import Tasks.Status;
import Tasks.Subtask;
import Tasks.Task;



public class Main {
    public static void main(String[] args) {
         TaskManager inMemoryTaskManager = Managers.getDefault();

        inMemoryTaskManager.createTask(new Task("Таск 1",  "Доделать тз", Status.NEW  ));
        inMemoryTaskManager.createTask(new Task("Таск 2","Доделать тз",  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 3", "Купить еды"
, Status.NEW ));
        inMemoryTaskManager.createTask(new Task("Таск 4", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 5", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 6", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 7", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 8", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 9", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 10", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 11", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 12", "Купить еды"
,  Status.NEW));
        inMemoryTaskManager.createTask(new Task("Таск 13", "Купить еды", Status.NEW ));
        inMemoryTaskManager.createEpic(new Epic("Эпик 1",  "Покупка квартиры"
));
        inMemoryTaskManager.createEpic(new Epic("Эпик 2",   "Продажа дачи"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 3",  "Покупка квартиры"
));
        inMemoryTaskManager.createEpic(new Epic("Эпик 4",   "Продажа дачи"));
        inMemoryTaskManager.createEpic(new Epic("Эпик 5",  "Покупка квартиры"
));
        inMemoryTaskManager.createEpic(new Epic("Эпик 6",   "Продажа дачи"));
        inMemoryTaskManager.createSubtask(new Subtask("Описание-1", "Tasks.Subtask-1", Status.NEW, 3));//addSubtask(new SubTask("Сабтаск 1", Status.NEW, "---", 15));
        inMemoryTaskManager.createSubtask(new Subtask("Описание-2", "Tasks.Subtask-2", Status.NEW, 3));//addSubTask(new SubTask("Сабтаск 2", Status.NEW, "---", 15));
        inMemoryTaskManager.createSubtask(new Subtask("Описание-3", "Tasks.Subtask-3", Status.NEW, 4));//addSubTask(new SubTask("Сабтаск 3", Status.NEW, "---", 16));

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
//        inMemoryTaskManager.deleteSubtaskById(5);
//        inMemoryTaskManager.updateSubtask(new SubTask("Подписать договор", Status.IN_PROGRESS, "Заключить договор", 3));
//        System.out.println(inMemoryTaskManager.getEpics());
//        System.out.println(inMemoryTaskManager.getAllSubtasks()); */
        for (int i = 1; i <= 13; i++) {
        inMemoryTaskManager.getTaskById(i);
    }
        for (int i = 14; i <= 18; i++) {
        inMemoryTaskManager.getEpicById(i);
    }
        inMemoryTaskManager.getTaskById(4);
        inMemoryTaskManager.getSubtaskById(20);
        inMemoryTaskManager.getSubtaskById(21);
        inMemoryTaskManager.getTaskById(9);
        inMemoryTaskManager.getSubtaskById(22);

        System.out.println(inMemoryTaskManager.getHistory());
}



  /*  public static void printTasks() {
        if (inMemoryTaskManager.getTasks().size() == 0) {
            System.out.println("Tasks.Task list is empty");
            return;
        }
        for (Task task : inMemoryTaskManager.getTasks().values()) {
            System.out.println("Tasks.Task{" +
                    "description='" + task.getDescription() + '\'' +
                    ", id=" + task.getId() +
                    ", name='" + task.getName() + '\'' +
                    ", status=" + task.getStatus() +
                    '}');
        }
    }

    public static void printEpics() {
        if (inMemoryTaskManager.getEpics().size() == 0) {
            System.out.println("Tasks.Epic list is empty");
            return;
        }
        for (Epic epic : inMemoryTaskManager.getEpics().values()) {
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
        if (inMemoryTaskManager.getSubtasks().size() == 0) {
            System.out.println("Tasks.Subtask list is empty");
            return;
        }
        for (Subtask subtask : inMemoryTaskManager.getSubtasks().values()) {
            System.out.println("Tasks.Subtask{" +
                    "epicId=" + subtask.getEpicId() +
                    ", description='" + subtask.getDescription() + '\'' +
                    ", id=" + subtask.getId() +
                    ", name='" + subtask.getName() + '\'' +
                    ", status=" + subtask.getStatus() +
                    '}');
        }
    }*/
}
