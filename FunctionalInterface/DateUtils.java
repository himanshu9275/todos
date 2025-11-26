import java.time.*;
import java.time.format.*;

public interface DateUtils {
    static String formatDate(LocalDate d, String pattern) {
        return d.format(DateTimeFormatter.ofPattern(pattern));
    }
}

// Demo
public class DateFormatDemo {
    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate(LocalDate.now(), "dd-MM-yyyy"));
        System.out.println(DateUtils.formatDate(LocalDate.now(), "yyyy/MM/dd"));
    }
}
