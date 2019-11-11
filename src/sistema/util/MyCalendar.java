package sistema.util;

import java.util.GregorianCalendar;

public class MyCalendar extends GregorianCalendar {
    @Override
    public String toString() {
        return this.get(DAY_OF_MONTH) + "/" + this.get(MONTH) + "/" + this.get(YEAR);
    }

    public MyCalendar(int day, int month, int year) {
        super(day, month, year);
    }

    public static MyCalendar toDate(String str) throws IllegalArgumentException {
        String[] datePart = str.split("/");
        if(datePart.length != 3)
            throw new IllegalArgumentException(str);
        return new MyCalendar(Integer.parseInt(datePart[2]), Integer.parseInt(datePart[1]), Integer.parseInt(datePart[0]));
    }
}