package cs3220.midterm1.model;

import java.util.ArrayList;
import java.util.List;

public class Lesson {

    private String name;
    private int count;
    private List<String> attendedDates;

    public Lesson(String name, int count) {
        this.name = name;
        this.count = count;
        this.attendedDates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getRemaining() {
        return count - attendedDates.size(); // Remaining lessons
    }

    public List<String> getAttendedDates() {
        return attendedDates;
    }

    public void attendLesson(String date) {
        if (getRemaining() > 0) {
            attendedDates.add(date);
        }
    }

    public void addCount(int additionalCount) {
        this.count += additionalCount;
    }
}
