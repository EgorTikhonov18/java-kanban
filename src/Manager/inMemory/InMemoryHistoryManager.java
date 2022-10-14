package Manager.inMemory;

import Manager.interfaces.HistoryManager;
import Tasks.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> listHistory = new ArrayList<>();
    private final Map<Integer, Node> customLinkedList = new HashMap<>();
    private Node firstNode;
    private Node lastNode;

    private static class Node {
        private Node previous;
        private Node next;
        private Task value;

        public Node(Node previous, Task value, Node next) {

            this.previous = previous;

            this.value = value;

            this.next = next;

        }
    }
    public Node setLast(Task task) { // данный метод добавляет задачу в конец списка
        final Node secondLast = lastNode;
        final Node newNode = new Node(secondLast, task, null);
        lastNode = newNode;
        if (secondLast != null) {
            secondLast.next = newNode;
        } else {
            firstNode = newNode;
        }
        return newNode;
    }
    public void removeNode(Node value) {
        if (value == firstNode) {
            if (firstNode.next != null)
                firstNode = firstNode.next;
            else
                firstNode = null;
        }
        if (value == lastNode) {
            if (lastNode.previous != null)
                lastNode = lastNode.previous;
            else
                lastNode = null;
        }
        if (value.previous != null) {
            value.previous.next = value.next;
            if (value.next != null) {
                value.next.previous = value.previous;
            }
        }
    }
    public List<Task> getTasks() {  // берет задчи из списка в arraylist
        List<Task> allListHistory = new ArrayList<>();
        Node node = firstNode;
        while (node != null) {
            allListHistory.add(node.value);
            node = node.next;
        }
        return allListHistory;
    }
    @Override

    public void add(Task task) {
        if (customLinkedList.containsKey(task.getId())) {
            removeNode(customLinkedList.get(task.getId()));
            customLinkedList.remove(task.getId());
        }
        Node nodeAdded = setLast(task);
        customLinkedList.put(task.getId(), nodeAdded);
    }
    public void remove(int id) { //реализовал
        if (customLinkedList.containsKey(id)) {
            removeNode(customLinkedList.get(id));
            customLinkedList.remove(id);
        }
    }
    @Override
    public List<Task> getHistory() {
        listHistory = getTasks();
        return listHistory;
    }
} 