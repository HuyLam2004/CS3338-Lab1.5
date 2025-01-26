@import cs3220.midterm1.model.Lesson
@import java.util.List
@param List<Lesson> lessons

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lesson Tracker</title>
</head>
<body>

<div>
    <h1>Lessons</h1>
    <a href="/add">Add Lessons</a>
    <table border="1">
        <thead>
        <tr>
            <th>Lesson</th>
            <th>Remaining</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        @for(Lesson lesson : lessons)
            <tr>
                <td><a href="/view/${lesson.getName()}">${lesson.getName()}</a></td>
                <td>${lesson.getRemaining()}</td>
                <td>
                    @if(lesson.getRemaining() > 0)
                        <a href="/attend/${lesson.getName()}">Attended</a>
                    @endif
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>

</body>
</html>
