import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateConverter {

    public static Date convertStringToDate(String s) throws ParseException{
        DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("MM-dd-yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                .appendOptional(DateTimeFormatter.ofPattern("MM.dd.yyyy"));
                // Can add more patterns

        try {
            LocalDate ldate = LocalDate.parse(s, formatterBuilder.toFormatter());
            return Date.from(ldate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            throw new ParseException("Unable to parse the date: " + s, 0);
        }
    }
}
