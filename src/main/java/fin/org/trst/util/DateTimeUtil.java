package fin.org.trst.util;

import java.time.LocalDateTime;

public class DateTimeUtil {

    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime updatedAt() {
        return LocalDateTime.now().plusMinutes(5);
    }
}
