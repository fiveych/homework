import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tags.Positive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTasksTest {

    private TaskList taskList;

    private Task task1;
    private Task task2;
    private Task task3;

    @BeforeEach
    void setUp() {

        task1 = new Task("T1", "D1", Priority.LOW, LocalDate.now().minusDays(1));
        task2 = new Task("T2", "D2", Priority.MEDIUM, LocalDate.now().plusDays(1));
        task3 = new Task("T3", "D3", Priority.HIGH, LocalDate.now());

        taskList = new TaskList("My task list", List.of(task1, task2, task3));
    }

    @Positive
    @Test
    void testGetTasksNumber() {

        final int expectedTasksNumber = 3;

        assertEquals(expectedTasksNumber, taskList.getTasksNumber(),
                "Incorrect tasks number");
    }

    @Positive
    @ParameterizedTest
    @EnumSource(Priority.class)
    void testGetTasksByPriority(Priority priority) {

        final List<Task> expectedTasks = new ArrayList<>();

        switch (priority) {
            case LOW:
                expectedTasks.add(task1);
                break;
            case MEDIUM:
                expectedTasks.add(task2);
                break;
            case HIGH:
                expectedTasks.add(task3);
                break;
        }

        final List<Task> actualTasks = taskList.getTasks(priority);

        assertEquals(expectedTasks, actualTasks,
                "Incorrect tasks with priority " + priority);
    }

    @Positive
    @Test
    void testGetUnfinishedTasks() {

        task1.setCompleted(true);
        task2.setCompleted(true);

        final List<Task> expectedTasks = List.of(task3);
        final List<Task> actualTasks = taskList.getUnfinishedTasks();

        assertEquals(expectedTasks, actualTasks,
                "Incorrect unfinished tasks");
    }

    @Positive
    @Test
    void testGetOverdueTasks() {

        final List<Task> expectedTasks = List.of(task1);
        final List<Task> actualTasks = taskList.getOverdueTasks();

        assertEquals(expectedTasks, actualTasks,
                "Incorrect overdue tasks");
    }
}
