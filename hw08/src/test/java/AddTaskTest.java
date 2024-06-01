import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tags.Negative;
import tags.Positive;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTaskTest {

    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList("My task list");
    }

    private static List<Task> createCorrectTasks() {
        return List.of(
                new Task("T1", "D1", Priority.LOW, LocalDate.now().minusDays(1)),
                new Task("T2", null, Priority.HIGH, LocalDate.now().plusDays(1)),
                new Task("T3", "D3", Priority.HIGH, null),
                new Task("T4", null, Priority.HIGH, null)
        );
    }

    @Positive
    @ParameterizedTest
    @MethodSource("createCorrectTasks")
    void testAddTask(Task task) {

        taskList.addTask(task);

        assertTrue(taskList.getTasks().contains(task),
                "Task was not added");
    }

    private static List<Task> createIncorrectTasks() {
        return List.of(
                new Task(null, "D1", Priority.LOW, LocalDate.now().minusDays(1)),
                new Task("T2", "D2", null, LocalDate.now().plusDays(1)),
                new Task(null, "D3", null, LocalDate.now())
        );
    }

    @Negative
    @ParameterizedTest
    @MethodSource("createIncorrectTasks")
    void testNotAddTask(Task task) {

        taskList.addTask(task);

        assertTrue(taskList.getTasks().isEmpty(),
                "Incorrect task was added");
    }
}
