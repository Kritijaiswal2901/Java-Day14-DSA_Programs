import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class WeekDay {
    String dayName;
    String date;

    public WeekDay(String dayName, String date) {
        this.dayName = dayName;
        this.date = date;
    }

    @Override
    public String toString() {
        return dayName + " " + date;
    }
}

class Week {
    Queue<WeekDay> days;

    public Week() {
        this.days = new LinkedList<>();
    }

    public void addDay(WeekDay day) {
        days.add(day);
    }

    public void displayWeek() {
        for (WeekDay day : days) {
            System.out.print(day + "\t");
        }
        System.out.println();
    }
}

public class DSA_Prog13 {
    static int[][] calendar = new int[5][7];
    static int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static void initCal() {
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                calendar[i][j] = -10;
            }
        }
    }

    static void display(int m) {
        System.out.println("	Sun	Mon	Tue	Wed	Thu	Fri	Sat");

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] < 0 || calendar[i][j] > month[m - 1]) {
                    System.out.print("\t ");
                } else if (calendar[i][j] > 0) {
                    System.out.print("\t" + calendar[i][j] + " ");
                }
            }
            System.out.println("\t");
        }
    }

    static void putCalendar(int d) {
        int d1 = 1;
        for (int i = d; i < calendar[0].length; i++) {
            calendar[0][i] = d1++;
        }
        for (int i = 1; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                calendar[i][j] = d1++;
            }
        }
    }

    static void dispCalendar(int m, int y) {
        int d = dayOfWeek(m, y);
        initCal();
        putCalendar(d);
        display(m);
    }

    static int dayOfWeek(int m, int y) {
        int d = 1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter month");
        int m = s.nextInt();
        System.out.println("Enter year");
        int y = s.nextInt();
        s.close();

        Week week = createWeek();
        displayWeek(week);
    }

    private static Week createWeek() {
        Week week = new Week();

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] dates = new String[7];

        initCal();
        int d = dayOfWeek(1, 2023);
        putCalendar(d);

        for (int i = 0; i < calendar[0].length; i++) {
            dates[i] = calendar[0][i] == -10 ? "" : String.valueOf(calendar[0][i]);
        }

        for (int i = 0; i < daysOfWeek.length; i++) {
            WeekDay day = new WeekDay(daysOfWeek[i], dates[i]);
            week.addDay(day);
        }

        return week;
    }

    private static void displayWeek(Week week) {
        week.displayWeek();
    }
}
