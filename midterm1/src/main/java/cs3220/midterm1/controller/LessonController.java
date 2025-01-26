package cs3220.midterm1.controller;

import cs3220.midterm1.model.Lesson;
import cs3220.midterm1.repository.LessonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class LessonController {

    private final LessonRepository lessonRepository = new LessonRepository();

    @GetMapping("/")
    public String listLessons(Model model) {
        List<Lesson> lessons = lessonRepository.getLessons();
        model.addAttribute("lessons", lessons);
        return "index";
    }

    @GetMapping("/attend/{name}")
    public String attendLesson(@PathVariable String name) {
        Lesson lesson = lessonRepository.getLesson(name);
        if (lesson != null && lesson.getRemaining() > 0) {
            lesson.attendLesson(LocalDate.now().toString());
        }
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lessons", lessonRepository.getLessons());
        return "add";
    }

    @PostMapping("/add")
    public String addLesson(
            @RequestParam(required = false) String existingName,
            @RequestParam(required = false) String newName,
            @RequestParam int count
    ) {
        String lessonName;

        if (existingName != null && !existingName.isEmpty()) {
            lessonName = existingName;
        } else if (newName != null && !newName.isEmpty()) {
            lessonName = newName;
        } else {
            return "redirect:/add";
        }

        Lesson lesson = lessonRepository.getLesson(lessonName);
        if (lesson == null) {
            lessonRepository.addLesson(lessonName, count);
        } else {
            lesson.addCount(count);
        }

        return "redirect:/";
    }

    @GetMapping("/view/{name}")
    public String viewLesson(@PathVariable String name, Model model) {
        Lesson lesson = lessonRepository.getLesson(name);
        model.addAttribute("lesson", lesson);
        return "view";
    }
}
