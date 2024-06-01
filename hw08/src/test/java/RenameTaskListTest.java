import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tags.Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenameTaskListTest {

    private TaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new TaskList("My task list");
    }

    @Positive
    @Test
    void testRename() {

        final String expectedName = "New task list";
        taskList.setName(expectedName);

        assertEquals(expectedName, taskList.getName(),
                "Incorrect task list name after changing");
    }
}
