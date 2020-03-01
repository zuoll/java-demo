package callback;

import java.time.LocalDateTime;

public class AppTest {
    public static void main(String[] args) {
        Task task = new Simpletask();
        task.executeWith(new Callback() {
            @Override
            public void call() {
                System.out.println("execute callback,"+ LocalDateTime.now());
            }
        });
    }
}
