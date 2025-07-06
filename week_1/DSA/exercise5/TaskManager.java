package exercise5;
public class TaskManager {

    // Task class
    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public void display() {
            System.out.println("Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
        }
    }

    // Node class for linked list
    static class TaskNode {
        Task task;
        TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Linked list implementation
    static class TaskLinkedList {
        private TaskNode head;

        // Add task at end
        public void addTask(Task task) {
            TaskNode newNode = new TaskNode(task);
            if (head == null) {
                head = newNode;
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Task added successfully.");
        }

        // Search task by ID
        public Task searchTask(int taskId) {
            TaskNode current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        // Traverse and display all tasks
        public void traverseTasks() {
            if (head == null) {
                System.out.println("No tasks to display.");
                return;
            }
            TaskNode current = head;
            while (current != null) {
                current.task.display();
                current = current.next;
            }
        }

        // Delete task by ID
        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("Task list is empty.");
                return;
            }

            if (head.task.taskId == taskId) {
                head = head.next;
                System.out.println("Task deleted successfully.");
                return;
            }

            TaskNode current = head;
            TaskNode prev = null;

            while (current != null && current.task.taskId != taskId) {
                prev = current;
                current = current.next;
            }

            if (current == null) {
                System.out.println("Task not found.");
            } else {
                prev.next = current.next;
                System.out.println("Task deleted successfully.");
            }
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Develop Backend", "In Progress"));
        taskList.addTask(new Task(3, "Write Tests", "Pending"));

        // Traversing tasks
        System.out.println("\nAll tasks:");
        taskList.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for Task ID 2:");
        Task foundTask = taskList.searchTask(2);
        if (foundTask != null) {
            foundTask.display();
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        System.out.println("\nDeleting Task ID 2:");
        taskList.deleteTask(2);

        // Traversing after deletion
        System.out.println("\nAll tasks after deletion:");
        taskList.traverseTasks();
    }
}
