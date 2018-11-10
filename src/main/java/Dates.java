import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Calendar calendar = Calendar.getInstance();

    public static Date convertStringToDate(String stringDate) throws ParseException {
        calendar.setTime(dateFormat.parse(stringDate));
        Date newDate = calendar.getTime();
        return newDate;
    }

    public static Date getDateExpiration(String date, int addDays) throws ParseException {
        calendar.setTime(dateFormat.parse(date));
        calendar.add(Calendar.DAY_OF_MONTH, addDays);
        Date newDate = calendar.getTime();
        return newDate;
    }

    public static Boolean isSpoiled(Date dateExpiration, Date date) {
        if(dateExpiration.getTime() < date.getTime()) {
            return true;
        } else {
            return false;
        }
    }
}
