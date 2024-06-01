import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Task task = new Task("T1", "D1", Priority.LOW, LocalDate.now());
        System.out.println(task);
    }
}
