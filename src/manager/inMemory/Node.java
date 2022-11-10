package manager.inMemory;

import tasks.Task;

public class Node {

    private Task task;
    private manager.inMemory.Node prev;
    private manager.inMemory.Node next;

    public manager.inMemory.Node getNext() {
        return next;
    }

    public manager.inMemory.Node getPrev() {
        return prev;
    }

    public Task getTask() {
        return task;
    }

    public void setNext(manager.inMemory.Node next) {
        this.next = next;
    }

    public void setPrev(manager.inMemory.Node prev) {
        this.prev = prev;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}



