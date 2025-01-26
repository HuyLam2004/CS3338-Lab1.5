@import cs3220.midterm1.model.Lesson
@param Lesson lesson

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Attendance</title>
</head>
<body>

<h1>${lesson.getName()} - Attendance</h1>
<ol>
    @for(String date : lesson.getAttendedDates())
        <li>${date}</li>
    @endfor
</ol>
<a href="/">Back to Home</a>

</body>
</html>
