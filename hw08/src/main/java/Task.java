import java.time.LocalDate;
import java.util.Objects;

public class Task {

    private final String name;
    private final String description;
    private final Priority priority;
    private final LocalDate dueDate;
    private boolean isCompleted;

    public Task(String name, String description, Priority priority, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isExpired() {
        return dueDate.isBefore(LocalDate.now());
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isCompleted == task.isCompleted
                && Objects.equals(name, task.name)
                && Objects.equals(description, task.description)
                && priority == task.priority
                && Objects.equals(dueDate, task.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, priority, dueDate, isCompleted);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
