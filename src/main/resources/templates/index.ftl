<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="/example/moment.min.js"></script>
<script src="/example/snap.svg-min.js"></script>
<script src="/example/frappe-gantt.min.js"></script>
<script src="/example/jquery-3.1.1.min.js"></script>


<script>
    var tasks = [
        {
            id: 'Task 1',
            name: 'Redesign website',
            start: '2016-12-28',
            end: '2016-12-31',
            progress: 20,
            dependencies: 'Task 2, Task 3'
        },
        {
            id: 'Task 2',
            name: 'Redesign website',
            start: '2016-12-28',
            end: '2016-12-31',
            progress: 20,
            dependencies: 'Task 2, Task 3'
        }
    ]
    var gantt = new Gantt("#gantt", tasks);
</script>
<body>
<div id = "gannt"></div>
</body>
</html>