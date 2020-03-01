package callback;

import java.time.LocalDateTime;

public class Simpletask extends Task {
    @Override
    public void execute() {
        System.out.println("simple task execute,"+ LocalDateTime.now());
    }
}
