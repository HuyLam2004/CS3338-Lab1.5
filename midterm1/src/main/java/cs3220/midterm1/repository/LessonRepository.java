package cs3220.midterm1.repository;

import cs3220.midterm1.model.Lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonRepository {
    private final Map<String, Lesson> lessons = new HashMap<>();

    public LessonRepository() {
        // Initialize with some lessons
        lessons.put("Swimming", new Lesson("Swimming", 6));
        lessons.put("Tennis", new Lesson("Tennis", 9));
        lessons.put("Basketball", new Lesson("Basketball", 0));
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons.values());
    }

    public Lesson getLesson(String name) {
        return lessons.get(name);
    }

    public void addLesson(String name, int count) {
        if (!lessons.containsKey(name)) {
            lessons.put(name, new Lesson(name, count));
        } else {
            lessons.get(name).addCount(count);
        }
    }
}
