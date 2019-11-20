package sistema.util;

import java.util.GregorianCalendar;

/**
 * @author  Henrique Layber
 * @version 1.5v
 * Formatação do calendário gregoriano para utilização mais fácil, legível e direta para o Sistema PPGI
 */
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
        for(String s : datePart)
            s.trim();
        switch(datePart.length) {
            case 3:
                return new MyCalendar(Integer.parseInt(datePart[2]), Integer.parseInt(datePart[1]), Integer.parseInt(datePart[0]));
            case 1:
                return new MyCalendar(1, 1, Integer.parseInt(datePart[0]));
            default:
                throw new IllegalArgumentException(str);
        }
    }
}