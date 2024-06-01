import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private String name;
    private final List<Task> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }

    public TaskList(String name, List<Task> tasks) {
        this.name = name;
        this.tasks.addAll(tasks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        if (task.getName() != null && task.getPriority() != null) {
            tasks.add(task);
        }
    }

    public int getTasksNumber() {
        return tasks.size();
    }

    public List<Task> getTasks(Priority priority) {
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task> getUnfinishedTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public List<Task> getOverdueTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .filter(Task::isExpired)
                .collect(Collectors.toList());
    }

    public void removeTask(String name) {
        tasks.removeIf(task -> task.getName().equals(name));
    }

    public void removeCompletedTasks() {
        tasks.removeIf(Task::isCompleted);
    }

    public void removeAllTasks() {
        tasks.clear();
    }
}
