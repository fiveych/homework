import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tags.Negative;
import tags.Positive;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveTasksTest {

    private TaskList taskList;

    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {

        task1 = new Task("T1", "D1", Priority.LOW, LocalDate.now());
        task2 = new Task("T2", "D2", Priority.MEDIUM, LocalDate.now());

        taskList = new TaskList("My task list", List.of(task1, task2));
    }

    @Positive
    @Test
    void testRemoveTaskByName() {

        taskList.removeTask(task1.getName());

        assertFalse(taskList.getTasks().contains(task1),
                "Task was not removed");
    }

    @Negative
    @Test
    void testNotRemoveTaskIfNotExist() {

        List<Task> expectedTasks = taskList.getTasks();

        final String taskName = "T1000";
        taskList.removeTask(taskName);

        List<Task> actualTasks = taskList.getTasks();

        assertEquals(expectedTasks, actualTasks,
                "Incorrect task was removed");
    }

    @Positive
    @Test
    void testRemoveCompletedTasks() {

        task1.setCompleted(true);

        taskList.removeCompletedTasks();

        assertFalse(taskList.getTasks().contains(task1),
                "Completed tasks was not removed");
    }

    @Positive
    @Test
    void testRemoveAllTasks() {

        taskList.removeAllTasks();

        assertTrue(taskList.getTasks().isEmpty(),
                "Non-empty task list after deleting all tasks");
    }
}
