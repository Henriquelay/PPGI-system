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
}