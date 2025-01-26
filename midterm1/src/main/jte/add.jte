@import cs3220.midterm1.model.Lesson
@import java.util.List
@param List<Lesson> lessons

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Lesson</title>
</head>
<body>

<h2>Add Lessons</h2>

<form method="post" action="/add">
    <div>
        <label for="lessonSelect">Select Existing Lesson</label>
        <select name="existingName" id="lessonSelect">
            <option value="">-- Select an existing lesson --</option>
            @for(Lesson lesson : lessons)
                <option value="${lesson.getName()}">${lesson.getName()}</option>
            @endfor
        </select>
    </div>

    <div>
        <label for="newLesson">Or Enter New Lesson Name</label>
        <input type="text" name="newName" id="newLesson" placeholder="Enter new lesson name">
    </div>

    <div>
        <label for="lessonCount">Count</label>
        <input type="number" name="count" id="lessonCount" required min="1">
    </div>

    <button type="submit">Add Lesson</button>
</form>

<a href="/">Back to Home</a>

</body>
</html>
